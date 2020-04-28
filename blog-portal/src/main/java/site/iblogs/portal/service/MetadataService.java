package site.iblogs.portal.service;

import site.iblogs.common.api.PageResponse;
import site.iblogs.portal.model.params.MetaDataType;
import site.iblogs.portal.model.response.MetaDataResponse;

public interface MetadataService {
    PageResponse<MetaDataResponse> getMetadata(MetaDataType type, int pageNum, int pageSize);
}
