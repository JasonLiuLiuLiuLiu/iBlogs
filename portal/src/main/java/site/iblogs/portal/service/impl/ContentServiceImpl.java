package site.iblogs.portal.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.iblogs.mapper.ContentsMapper;
import site.iblogs.model.Contents;
import site.iblogs.model.ContentsExample;
import site.iblogs.portal.model.converter.ContentResponseConverter;
import site.iblogs.portal.model.params.ArticleParam;
import site.iblogs.portal.model.response.ContentResponse;
import site.iblogs.portal.service.ContentService;

import java.util.List;
import java.util.stream.Collectors;


/**
 * 内容服务实现类
 *
 * @author Liu Zhenyu on 3/11/2020
 */
@Service
public class ContentServiceImpl implements ContentService {

    @Autowired
    private ContentsMapper contentsMapper;

    @Autowired
    private ContentResponseConverter contentResponseConverter;

    @Override
    public List<Contents> listAllContent() {
        return contentsMapper.selectByExample(new ContentsExample());
    }

    @Override
    public List<Contents> findArticles(ArticleParam param) {
        return null;
    }

    @Override
    public List<ContentResponse> listContent(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Contents> contents = contentsMapper.selectByExampleWithBLOBs(new ContentsExample());
        return contents.stream().map(u -> contentResponseConverter.domain2dto(u)).collect(Collectors.toList());
    }
}
