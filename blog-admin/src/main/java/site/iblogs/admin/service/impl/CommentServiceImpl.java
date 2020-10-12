package site.iblogs.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.iblogs.admin.service.CommentService;
import site.iblogs.common.api.PageParam;
import site.iblogs.common.api.PageResponse;
import site.iblogs.common.dto.enums.CommentStatus;
import site.iblogs.common.dto.response.CommentResponse;
import site.iblogs.mapper.CommentMapper;

/**
 * @author: liuzhenyulive@live.com
 * @date: 10/12/2020 22:29
 */
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;

    @Override
    public PageResponse<CommentResponse> commentList(PageParam pageParam) {
        return null;
    }

    @Override
    public Boolean deleteComment(Integer id) {
        return null;
    }

    @Override
    public CommentStatus updateStatus(CommentStatus status) {
        return null;
    }
}
