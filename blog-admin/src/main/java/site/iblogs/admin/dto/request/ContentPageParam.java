package site.iblogs.admin.dto.request;

import lombok.Data;
import site.iblogs.common.api.PageRequest;
import site.iblogs.common.dto.enums.ContentType;

@Data
public class ContentPageParam extends PageRequest {
    private ContentType type;
}
