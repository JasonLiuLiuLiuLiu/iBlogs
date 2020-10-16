package site.iblogs.admin.service;

import site.iblogs.admin.dto.request.CommentStatusUpdateParam;
import site.iblogs.common.api.PageResponse;
import site.iblogs.common.dto.enums.CommentStatus;
import site.iblogs.common.dto.request.CommentPageParam;
import site.iblogs.common.dto.response.CommentResponse;

/**
 * @author: liuzhenyulive@live.com
 * @date: 10/12/2020 22:29
 */
public interface CommentService {


    PageResponse<CommentResponse> commentList(CommentPageParam pageParam);


    Boolean deleteComment(Long id);


    CommentStatus updateStatus(CommentStatusUpdateParam param);
}
