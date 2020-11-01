package site.iblogs.admin.dto.request;

import lombok.Data;
import site.iblogs.common.dto.enums.CommentStatus;

/**
 * @author: liuzhenyulive@live.com
 * @date: 10/12/2020 23:18
 */
@Data
public class CommentStatusUpdateParam {
    private Long commentId;
    private CommentStatus status;
}
