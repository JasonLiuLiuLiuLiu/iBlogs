package site.iblogs.admin.dto.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import site.iblogs.common.dto.response.MetaResponse;
import site.iblogs.common.dto.enums.ContentStatus;
import site.iblogs.common.dto.enums.ContentType;

import java.util.Date;

/**
 * 文章API响应实体
 *
 * @author Liu Zhenyu on 3/22/2020
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ContentSaveRequest {
    private Long id;
    private String title;
    private String slug;
    private String content;
    private ContentType type;
    private String FmtType;
    private MetaResponse[] Tags;
    private ContentStatus status;
    private MetaResponse Category;
    private Boolean allowComment;
    private Boolean allowPing;
    private Boolean allowFeed;
    private Date Created;
}

