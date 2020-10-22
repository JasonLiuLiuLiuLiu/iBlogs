package site.iblogs.admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.iblogs.admin.dto.request.ContentDeleteParam;
import site.iblogs.admin.dto.request.ContentPageParam;
import site.iblogs.admin.dto.request.ContentStatusUpdateParam;
import site.iblogs.admin.service.ContentService;
import site.iblogs.common.api.PageResponse;
import site.iblogs.common.conventer.ContentResponseConverter;
import site.iblogs.common.dto.response.ContentResponse;
import site.iblogs.mapper.ContentMapper;
import site.iblogs.model.Content;
import site.iblogs.model.ContentExample;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContentServiceImpl implements ContentService {
    @Autowired
    private ContentMapper contentMapper;
    @Autowired
    private ContentResponseConverter contentResponseConverter;
    @Override
    public PageResponse<ContentResponse> page(ContentPageParam pageParam) {
        PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize());
        ContentExample contentsExample = new ContentExample();
        ContentExample.Criteria criteria= contentsExample.createCriteria();
        criteria.andDeletedEqualTo(false);
        if(pageParam.getType()!=null){
            criteria.andTypeEqualTo(pageParam.getType().ordinal());
        }
        List<Content> contents = contentMapper.selectByExampleWithBLOBs(contentsExample);
        PageInfo<Content> pageInfo = new PageInfo<>(contents);
        return PageResponse.restPage(contents.stream().map(u -> contentResponseConverter.domain2dto(u)).collect(Collectors.toList()), pageInfo);
    }

    @Override
    public Boolean status(ContentStatusUpdateParam param) {
        Content content=contentMapper.selectByPrimaryKey(param.getId());
        if(content==null){
            return false;
        }
        content.setStatus(param.getStatus().ordinal());
        contentMapper.updateByPrimaryKeySelective(content);
        return true;
    }

    @Override
    public Boolean delete(ContentDeleteParam param) {
        Content content=contentMapper.selectByPrimaryKey(param.getId());
        if(content==null){
            return false;
        }
        content.setDeleted(true);
        contentMapper.updateByPrimaryKeySelective(content);
        return true;
    }
}
