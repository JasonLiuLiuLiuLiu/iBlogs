package site.iblogs.admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.iblogs.admin.dto.request.CommentStatusUpdateParam;
import site.iblogs.admin.service.CommentService;
import site.iblogs.common.api.PageParam;
import site.iblogs.common.api.PageResponse;
import site.iblogs.common.conventer.CommentConverter;
import site.iblogs.common.dto.enums.CommentStatus;
import site.iblogs.common.dto.request.CommentPageParam;
import site.iblogs.common.dto.response.CommentResponse;
import site.iblogs.common.utils.GravatarTools;
import site.iblogs.mapper.CommentMapper;
import site.iblogs.model.Comment;
import site.iblogs.model.CommentExample;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: liuzhenyulive@live.com
 * @date: 10/12/2020 22:29
 */
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private CommentConverter commentConverter;

    @Override
    public PageResponse<CommentResponse> commentList(CommentPageParam pageParam) {
        PageHelper.startPage(pageParam.getIndex(), pageParam.getLimit());
        CommentExample example = new CommentExample();
        example.createCriteria().andDeletedEqualTo(false);
        if (pageParam.getContentId() != null) {
            example.createCriteria().andCidEqualTo(pageParam.getContentId());
        }
        List<Comment> comments = commentMapper.selectByExampleWithBLOBs(example);
        PageInfo<Comment> pageInfo = new PageInfo<>(comments);
        return PageResponse.restPage(comments.stream().map(u -> {
            CommentResponse response = commentConverter.domain2dto(u);
            response.setMailPic(GravatarTools.computeGravatarUrl(u.getMail(), 0, null));
            return response;
        }).collect(Collectors.toList()), pageInfo);
    }

    @Override
    public Boolean deleteComment(Long id) {
        Comment comment = commentMapper.selectByPrimaryKey(id);
        if (comment != null) {
            comment.setDeleted(true);
            commentMapper.updateByPrimaryKey(comment);
            return true;
        }
        return false;
    }

    @Override
    public CommentStatus updateStatus(CommentStatusUpdateParam param) {
        Comment comment = commentMapper.selectByPrimaryKey(param.getCommentId());
        comment.setStatus(param.getStatus().ordinal());
        commentMapper.updateByPrimaryKey(comment);
        return param.getStatus();
    }
}
