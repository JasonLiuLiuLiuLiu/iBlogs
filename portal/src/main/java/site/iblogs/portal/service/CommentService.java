package site.iblogs.portal.service;

import site.iblogs.common.api.PageResponse;
import site.iblogs.portal.model.response.CommentResponse;

public interface CommentService {
    PageResponse<CommentResponse> getComment(int cid,int pageNum, int pageSize);
}
