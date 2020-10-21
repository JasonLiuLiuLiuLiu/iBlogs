package site.iblogs.admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.iblogs.admin.dto.request.MetaPageRequest;
import site.iblogs.admin.dto.request.MetaParam;
import site.iblogs.admin.dto.response.MetaResponse;
import site.iblogs.admin.service.MetaService;
import site.iblogs.common.api.PageResponse;
import site.iblogs.common.dto.enums.MetaType;
import site.iblogs.mapper.MetaMapper;
import site.iblogs.model.Meta;
import site.iblogs.model.MetaExample;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MetaServiceImpl implements MetaService {
    @Autowired
    private MetaMapper metaMapper;

    @Override
    public MetaResponse saveMeta(MetaParam param) {
        MetaResponse response = new MetaResponse();
        response.setName(param.getName());
        response.setType(param.getType());
        MetaExample example=new MetaExample();
        MetaExample.Criteria criteria=example.createCriteria();
        criteria.andDeletedEqualTo(false);
        if(param.getId()!=null){
            criteria.andIdNotEqualTo(param.getId());
        }
        criteria.andSlugEqualTo(param.getSlug());
        Long count=metaMapper.countByExample(example);
        if(count>0){
            throw new IllegalArgumentException("slug已存在");
        }
        if (param.getId() != null) {
            Meta meta = metaMapper.selectByPrimaryKey(param.getId());
            meta.setName(param.getName());
            meta.setSlug(param.getSlug());
            meta.setDescription(param.getDescription());
            metaMapper.updateByPrimaryKeyWithBLOBs(meta);
            response.setId(param.getId());
        } else {
            Meta meta = new Meta();
            meta.setName(param.getName());
            meta.setType(param.getType().ordinal());
            meta.setCreated(new Date());
            meta.setSlug(param.getSlug());
            meta.setDescription(param.getDescription());
            meta.setSort(0);
            meta.setParent(0L);
            meta.setCount(0L);
            meta.setDeleted(false);
            metaMapper.insert(meta);
            response.setId(meta.getId());
        }
        return response;
    }

    @Override
    public Boolean deleteMeta(Long mid) {
        Meta meta = metaMapper.selectByPrimaryKey(mid);
        if (meta != null) {
            meta.setDeleted(true);
            metaMapper.updateByPrimaryKeySelective(meta);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public PageResponse<MetaResponse> page(MetaPageRequest request) {
        PageHelper.startPage(request.getPageNum(), request.getPageSize());
        MetaExample example = new MetaExample();
        example.createCriteria().andTypeEqualTo(request.getType().ordinal()).andDeletedEqualTo(false);
        List<Meta> metas = metaMapper.selectByExampleWithBLOBs(example);
        PageInfo<Meta> pageInfo = new PageInfo<>(metas);
        List<MetaResponse> responses = metas.stream().map(u -> new MetaResponse(u.getId(), u.getName(), MetaType.values()[u.getType()], u.getSlug(), u.getDescription(), u.getCount())).collect(Collectors.toList());
        return PageResponse.restPage(responses, pageInfo);
    }
}
