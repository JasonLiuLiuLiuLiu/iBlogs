package site.iblogs.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import site.iblogs.admin.dto.request.MetaPageRequest;
import site.iblogs.admin.dto.request.MetaParam;
import site.iblogs.admin.dto.response.MetaResponse;
import site.iblogs.admin.service.MetaService;
import site.iblogs.mapper.MetaMapper;
import site.iblogs.model.Meta;

import java.util.List;

public class MetaServiceImpl implements MetaService {
    @Autowired
    private MetaMapper metaMapper;
    @Override
    public MetaResponse saveMeta(MetaParam param) {
        if(param.getId()!=null){
            Meta meta=metaMapper.selectByPrimaryKey(param.getId());
            meta.setName(param.getName());
            metaMapper.updateByPrimaryKeyWithBLOBs(meta);
        }else {
            Meta meta=new Meta();
            meta.setName(param.getName());
            meta.setType(param.getType());


        }
    }

    @Override
    public Boolean deleteMeta(Long mid) {
        return null;
    }

    @Override
    public List<MetaResponse> page(MetaPageRequest request) {
        return null;
    }
}
