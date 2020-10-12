package site.iblogs.admin.service;

import site.iblogs.common.api.PageParam;
import site.iblogs.common.api.PageResponse;
import site.iblogs.common.dto.enums.CommentStatus;
import site.iblogs.common.dto.response.CommentResponse;

/**
 * @author: liuzhenyulive@live.com
 * @date: 10/12/2020 22:29
 */
public interface CommentService {


    PageResponse<CommentResponse> commentList(PageParam pageParam);


    Boolean deleteComment(Integer id);


    CommentStatus updateStatus(CommentStatus status);
}
