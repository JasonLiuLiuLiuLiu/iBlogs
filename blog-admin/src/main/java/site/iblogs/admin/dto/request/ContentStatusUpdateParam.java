package site.iblogs.admin.dto.request;

import lombok.Data;
import site.iblogs.common.dto.enums.ContentStatus;

@Data
public class ContentStatusUpdateParam {
    private Long id;
    private ContentStatus status;
}
