package site.iblogs.admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import site.iblogs.admin.dto.request.*;
import site.iblogs.admin.service.MetaService;
import site.iblogs.admin.service.UserService;
import site.iblogs.common.dto.request.ContentSaveRequest;
import site.iblogs.common.dto.response.ContentEditResponse;
import site.iblogs.admin.service.ContentService;
import site.iblogs.common.api.PageResponse;
import site.iblogs.common.conventer.ContentResponseConverter;
import site.iblogs.common.dto.response.ContentResponse;
import site.iblogs.mapper.ContentMapper;
import site.iblogs.model.Content;
import site.iblogs.model.ContentExample;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContentServiceImpl implements ContentService {
    @Autowired
    private ContentMapper contentMapper;
    @Autowired
    private ContentResponseConverter contentResponseConverter;
    @Autowired
    private UserService userService;

    @Override
    public PageResponse<ContentResponse> page(ContentPageParam pageParam) {
        PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize());
        ContentExample contentsExample = new ContentExample();
        ContentExample.Criteria criteria = contentsExample.createCriteria();
        criteria.andDeletedEqualTo(false);
        if (pageParam.getType() != null) {
            criteria.andTypeEqualTo(pageParam.getType().ordinal());
        }
        List<Content> contents = contentMapper.selectByExampleWithBLOBs(contentsExample);
        PageInfo<Content> pageInfo = new PageInfo<>(contents);
        return PageResponse.restPage(contents.stream().map(u -> contentResponseConverter.domain2dto(u)).collect(Collectors.toList()), pageInfo);
    }

    @Override
    public Boolean status(ContentStatusUpdateParam param) {
        Content content = contentMapper.selectByPrimaryKey(param.getId());
        if (content == null) {
            return false;
        }
        content.setStatus(param.getStatus().ordinal());
        contentMapper.updateByPrimaryKeySelective(content);
        return true;
    }

    @Override
    public Boolean delete(ContentDeleteParam param) {
        Content content = contentMapper.selectByPrimaryKey(param.getId());
        if (content == null) {
            return false;
        }
        content.setDeleted(true);
        contentMapper.updateByPrimaryKeySelective(content);
        return true;
    }

    @Override
    public ContentEditResponse details(ContentDetailRequest param) throws Exception {
        Content content = contentMapper.selectByPrimaryKey(param.getId());
        if (content == null) {
            throw new Exception("Not found content with id:" + param.getId());
        }
        ContentEditResponse response = contentResponseConverter.domain2EditResponse(content);
        if (StringUtils.isNotEmpty(content.getTags()) && content.getTags().split(",").length > 0) {
            response.setTags(content.getTags().split(","));
        }
        return response;
    }

    @Override
    public Boolean save(ContentSaveRequest param) {
        Content content = contentResponseConverter.saveRequest2Domain(param);
        content.setDeleted(false);
        content.setModified(new Date());
        content.setAuthorid(userService.info().getId());
        if (content.getId() == null) {
            Content oldContent = contentMapper.selectByPrimaryKey(content.getId());
            content.setHits(oldContent.getHits());
            content.setThumbimg(oldContent.getThumbimg());
            content.setCommentsnum(oldContent.getCommentsnum());
            contentMapper.insertSelective(content);
        } else {
            content.setHits(0);
            content.setCommentsnum(0);
            contentMapper.updateByPrimaryKeyWithBLOBs(content);
        }
        return true;
    }
}
