package site.iblogs.portal.service;

import site.iblogs.common.api.PageResponse;
import site.iblogs.common.dto.enums.MetaType;
import site.iblogs.portal.model.response.MetaDataResponse;

public interface MetadataService {
    PageResponse<MetaDataResponse> getMetadata(MetaType type, int pageNum, int pageSize);
}
