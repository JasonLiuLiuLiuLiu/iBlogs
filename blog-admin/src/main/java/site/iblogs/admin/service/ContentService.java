package site.iblogs.admin.service;

import site.iblogs.admin.dto.request.ContentDeleteParam;
import site.iblogs.admin.dto.request.ContentPageParam;
import site.iblogs.admin.dto.request.ContentStatusUpdateParam;
import site.iblogs.common.api.PageResponse;
import site.iblogs.common.dto.response.ContentResponse;

public interface ContentService {
    PageResponse<ContentResponse> page(ContentPageParam pageParam);
    Boolean status(ContentStatusUpdateParam param);
    Boolean delete(ContentDeleteParam param);
}
