package site.iblogs.portal.service;

import site.iblogs.common.api.PageResponse;
import site.iblogs.model.Content;
import site.iblogs.portal.model.params.ArticleParam;
import site.iblogs.portal.model.response.ArchivesResponse;
import site.iblogs.common.dto.response.ContentResponse;

import java.util.Date;
import java.util.List;

/**
 * 内容服务类
 *
 * @author Liu Zhenyu on 3/11/2020
 */

public interface ContentService {

    List<Content> getTopContent(Integer topNum,boolean containContent);

    List<Content> findArticles(ArticleParam param);

    PageResponse<ContentResponse> listContent(int pageNum, int pageSize, String orderType, Boolean summary);

    ContentResponse getByUrl(String url);

    PageResponse<ContentResponse> getContentByMetaData(int type, String name, int pageNum, int pageSize);

    List<ArchivesResponse> contentArchives();

    PageResponse<ContentResponse> getContentByArchive(Date date, int pageNum, int pageSize);
}
