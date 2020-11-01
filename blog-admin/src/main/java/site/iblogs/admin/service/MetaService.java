package site.iblogs.admin.service;

import site.iblogs.admin.dto.request.MetaPageRequest;
import site.iblogs.admin.dto.request.MetaParam;
import site.iblogs.common.dto.enums.MetaType;
import site.iblogs.common.dto.response.MetaResponse;
import site.iblogs.common.api.PageResponse;
import site.iblogs.model.Meta;

import java.util.List;

public interface MetaService {
    MetaResponse saveMeta(MetaParam param);
    Boolean deleteMeta(Long mid);
    PageResponse<MetaResponse> page(MetaPageRequest request);
    List<MetaResponse> getMetaByNames(String[] names, MetaType type);
}
