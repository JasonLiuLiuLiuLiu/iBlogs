package site.iblogs.portal.model.response;

import site.iblogs.common.api.PageResponse;

public class IndexContentResponse {
    private String displayType;
    private String displayMeta;
    private String orderType;
    private PageResponse<ContentResponse> contents;
}
