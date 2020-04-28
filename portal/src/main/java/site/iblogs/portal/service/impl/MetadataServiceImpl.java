package site.iblogs.portal.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.iblogs.common.api.PageResponse;
import site.iblogs.mapper.MetasMapper;
import site.iblogs.model.Metas;
import site.iblogs.model.MetasExample;
import site.iblogs.portal.model.params.MetaDataType;
import site.iblogs.portal.model.response.MetaDataResponse;
import site.iblogs.portal.service.MetadataService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MetadataServiceImpl implements MetadataService {
    @Autowired
    private MetasMapper metasMapper;

    @Override
    public PageResponse<MetaDataResponse> getMetadata(MetaDataType type, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        MetasExample example = new MetasExample();
        example.createCriteria().andTypeEqualTo(type.ordinal());
        List<Metas> metas = metasMapper.selectByExampleWithBLOBs(example);
        PageInfo<Metas> pageInfo=new PageInfo<>(metas);
        return PageResponse.restPage(metas.stream().map(u->new MetaDataResponse(u.getName(),u.getCount())).collect(Collectors.toList()),pageInfo);
    }
}
