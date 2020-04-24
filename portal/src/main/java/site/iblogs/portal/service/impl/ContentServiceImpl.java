package site.iblogs.portal.service.impl;

import com.github.pagehelper.PageHelper;
import org.jsoup.Jsoup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.iblogs.common.model.ConfigKey;
import site.iblogs.mapper.ContentsMapper;
import site.iblogs.model.Contents;
import site.iblogs.model.ContentsExample;
import site.iblogs.portal.model.converter.ContentResponseConverter;
import site.iblogs.portal.model.params.ArticleParam;
import site.iblogs.portal.model.response.ContentResponse;
import site.iblogs.portal.service.ContentService;
import site.iblogs.portal.service.OptionService;

import java.util.List;
import java.util.Optional;
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

    @Autowired
    private OptionService optionService;

    @Override
    public List<Contents> listAllContent() {
        return contentsMapper.selectByExample(new ContentsExample());
    }

    @Override
    public List<Contents> findArticles(ArticleParam param) {
        return null;
    }

    @Override
    public List<ContentResponse> listContent(int pageNum, int pageSize, Boolean summary) {
        PageHelper.startPage(pageNum, pageSize);
        List<Contents> contents = contentsMapper.selectByExampleWithBLOBs(new ContentsExample());
        if (summary) {
            int length;
            try {
                length = Integer.parseInt(optionService.getOption(ConfigKey.MaxIntroCount));
            } catch (Exception e) {
                length = 200;
            }
            final int lengthFinal = length;
            return contents.stream().peek(u -> {
                String contentText = Jsoup.parse(u.getContent()).body().text();
                int contentLength = contentText.length();
                contentLength = Math.min(lengthFinal, contentLength);
                u.setContent(contentText.substring(0, contentLength - 1));
            }).map(u -> contentResponseConverter.domain2dto(u)).collect(Collectors.toList());
        }
        return contents.stream().map(u -> contentResponseConverter.domain2dto(u)).collect(Collectors.toList());
    }

    public ContentResponse getByUrl(String url) {
        ContentsExample example = new ContentsExample();
        example.createCriteria().andSlugEqualTo(url);
        try {
            int id = Integer.parseInt(url);
            example.or().andIdEqualTo(id);
        } catch (NumberFormatException ignored) {

        }
        Optional<Contents> contents = contentsMapper.selectByExampleWithBLOBs(example).stream().findFirst();
        return contents.map(value -> contentResponseConverter.domain2dto(value)).orElse(null);
    }
}
