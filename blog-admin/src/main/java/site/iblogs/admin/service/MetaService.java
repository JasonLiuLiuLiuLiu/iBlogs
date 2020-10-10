package site.iblogs.admin.service;

import site.iblogs.admin.dto.request.MetaPageRequest;
import site.iblogs.admin.dto.request.MetaParam;
import site.iblogs.admin.dto.response.MetaResponse;
import site.iblogs.common.api.PageResponse;
import site.iblogs.common.model.MetaType;

import java.util.List;

public interface MetaService {
    MetaResponse saveMeta(MetaParam param);
    Boolean deleteMeta(Long mid);
    PageResponse<MetaResponse> page(MetaPageRequest request);
}
