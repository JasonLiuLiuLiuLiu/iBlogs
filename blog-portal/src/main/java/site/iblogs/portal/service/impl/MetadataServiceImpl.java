package site.iblogs.portal.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.iblogs.common.api.PageResponse;
import site.iblogs.mapper.MetaMapper;
import site.iblogs.model.Meta;
import site.iblogs.model.MetaExample;
import site.iblogs.common.dto.enums.MetaType;
import site.iblogs.portal.model.response.MetaDataResponse;
import site.iblogs.portal.service.MetadataService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MetadataServiceImpl implements MetadataService {
    @Autowired
    private MetaMapper metasMapper;

    @Override
    public PageResponse<MetaDataResponse> getMetadata(MetaType type, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        MetaExample example = new MetaExample();
        example.createCriteria().andTypeEqualTo(type.ordinal());
        example.createCriteria().andDeletedEqualTo(false);
        example.setOrderByClause("count desc");
        List<Meta> metas = metasMapper.selectByExampleWithBLOBs(example);
        PageInfo<Meta> pageInfo=new PageInfo<>(metas);
        return PageResponse.restPage(metas.stream().map(u->new MetaDataResponse(u.getName(),u.getCount())).collect(Collectors.toList()),pageInfo);
    }
}
