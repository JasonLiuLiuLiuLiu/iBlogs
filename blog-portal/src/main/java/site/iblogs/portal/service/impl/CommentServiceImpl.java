package site.iblogs.portal.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.iblogs.common.api.PageResponse;
import site.iblogs.common.model.ConfigKey;
import site.iblogs.common.utils.GravatarTools;
import site.iblogs.mapper.CommentsMapper;
import site.iblogs.model.Comments;
import site.iblogs.model.CommentsExample;
import site.iblogs.portal.model.converter.CommentConverter;
import site.iblogs.portal.model.request.CommentRequest;
import site.iblogs.portal.model.response.CommentResponse;
import site.iblogs.portal.service.CommentService;
import site.iblogs.portal.service.OptionService;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentsMapper commentsMapper;
    @Autowired
    private CommentConverter commentConverter;
    @Autowired
    private OptionService optionService;

    @Override
    public PageResponse<CommentResponse> getComment(int cid, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        CommentsExample example = new CommentsExample();
        example.createCriteria().andDeletedEqualTo(false);
        example.createCriteria().andCidEqualTo(cid);
        List<Comments> comments = commentsMapper.selectByExampleWithBLOBs(example);
        PageInfo<Comments> pageInfo = new PageInfo<>(comments);
        return PageResponse.restPage(comments.stream().map(u -> {
            CommentResponse response = commentConverter.domain2dto(u);
            response.setMailPic(GravatarTools.computeGravatarUrl(u.getMail(), 0, null));
            return response;
        }).collect(Collectors.toList()), pageInfo);
    }

    @Override
    public Boolean SaveComment(CommentRequest request) {
        Comments comment = commentConverter.request2domain(request);
        comment.setIsauthor(false);
        if (!Boolean.parseBoolean(optionService.getOption(ConfigKey.AllowCommentAudit).getValue())) {
            comment.setStatus(0);
        } else {
            comment.setStatus(1);
        }
        if (comment.getParent() == null) {
            comment.setParent(0);
        }
        comment.setOwnerid(0);
        comment.setCreated(new Date(System.currentTimeMillis()));
        comment.setDeleted(false);
        commentsMapper.insert(comment);
        return true;
    }
}
