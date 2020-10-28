package site.iblogs.admin.service;

import site.iblogs.admin.dto.request.*;
import site.iblogs.common.dto.response.ContentEditResponse;
import site.iblogs.common.api.PageResponse;
import site.iblogs.common.dto.response.ContentResponse;

public interface ContentService {
    PageResponse<ContentResponse> page(ContentPageParam pageParam);
    Boolean status(ContentStatusUpdateParam param);
    Boolean delete(ContentDeleteParam param);
    ContentEditResponse details(ContentDetailRequest param) throws Exception;
    Boolean save(ContentSaveRequest param);
}
