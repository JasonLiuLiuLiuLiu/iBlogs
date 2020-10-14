package site.iblogs.admin.service;

import site.iblogs.admin.dto.request.ContentPageParam;
import site.iblogs.common.api.PageResponse;
import site.iblogs.common.dto.response.ContentResponse;

public interface ContentService {
    PageResponse<ContentResponse> page(ContentPageParam pageParam);
}
