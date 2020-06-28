package site.iblogs.portal.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.iblogs.common.api.PageResponse;
import site.iblogs.common.utils.GravatarTools;
import site.iblogs.mapper.CommentsMapper;
import site.iblogs.model.Comments;
import site.iblogs.model.CommentsExample;
import site.iblogs.portal.model.converter.CommentResponseConverter;
import site.iblogs.portal.model.response.CommentResponse;
import site.iblogs.portal.service.CommentService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentsMapper commentsMapper;
    @Autowired
    private CommentResponseConverter commentResponseConverter;

    @Override
    public PageResponse<CommentResponse> getComment(int cid, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        CommentsExample example = new CommentsExample();
        example.createCriteria().andDeletedEqualTo(false);
        example.createCriteria().andCidEqualTo(cid);
        List<Comments> comments = commentsMapper.selectByExampleWithBLOBs(example);
        PageInfo<Comments> pageInfo = new PageInfo<>(comments);
        return PageResponse.restPage(comments.stream().map(u -> {
            CommentResponse response = commentResponseConverter.domain2dto(u);
            response.setMailPic(GravatarTools.computeGravatarUrl(u.getMail(), 0, null));
            return response;
        }).collect(Collectors.toList()), pageInfo);
    }
}
