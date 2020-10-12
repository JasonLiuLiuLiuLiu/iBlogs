package site.iblogs.portal.model.params;

import site.iblogs.common.api.PageParam;
import site.iblogs.common.dto.enums.CommentStatus;

public class CommentPageParam extends PageParam {
    public String url;
    public CommentStatus status;
}
