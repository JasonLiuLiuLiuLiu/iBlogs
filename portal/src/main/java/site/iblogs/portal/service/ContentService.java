package site.iblogs.portal.service;

import site.iblogs.model.Contents;
import site.iblogs.portal.model.params.ArticleParam;
import site.iblogs.portal.model.response.ContentResponse;

import java.util.List;

/**
 * 内容服务类
 *
 * @author Liu Zhenyu on 3/11/2020
 */

public interface ContentService {

    List<Contents> listAllContent();

    List<Contents> findArticles(ArticleParam param);

    List<ContentResponse> listContent(int pageNum, int pageSize);
}
