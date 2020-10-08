package site.iblogs.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.iblogs.admin.dto.request.OptionUpdateParam;
import site.iblogs.admin.dto.response.OptionResponse;
import site.iblogs.admin.service.OptionService;
import site.iblogs.mapper.OptionMapper;
import site.iblogs.model.Option;
import site.iblogs.model.OptionExample;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OptionServiceImpl implements OptionService {
    @Autowired
    private OptionMapper optionMapper;

    @Override
    public List<OptionResponse> getVisibleOptions() {
        OptionExample example = new OptionExample();
        OptionExample.Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false).andVisibleEqualTo(true);
        return optionMapper.selectByExample(example).stream().map(e->new OptionResponse(e.getName(),e.getValue(),e.getDescription(),e.getEditable())).collect(Collectors.toList());
    }

    @Override
    public Boolean updateOption(OptionUpdateParam param) {
        OptionExample example=new OptionExample();
        example.createCriteria().andNameEqualTo(param.getName());
        Option option=optionMapper.selectByExample(example).stream().findFirst().orElse(null);
        if(option!=null&&option.getEditable()&&option.getVisible()){
            option.setValue(param.getValue());
            optionMapper.updateByPrimaryKeySelective(option);
            return true;
        }else {
            return false;
        }
    }
}
