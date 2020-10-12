package site.iblogs.portal.service;

import site.iblogs.common.api.PageResponse;
import site.iblogs.common.dto.request.CommentRequest;
import site.iblogs.common.dto.response.CommentResponse;

public interface CommentService {
    PageResponse<CommentResponse> getComment(Long cid,int pageNum, int pageSize);
    Boolean SaveComment(CommentRequest comment);
}
