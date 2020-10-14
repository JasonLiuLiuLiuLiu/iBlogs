package site.iblogs.admin.dto.request;

import lombok.Data;
import site.iblogs.common.api.PageParam;
import site.iblogs.common.dto.enums.ContentType;

@Data
public class ContentPageParam extends PageParam {
    private ContentType contentType;
}
