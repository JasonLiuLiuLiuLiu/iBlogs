package site.iblogs.portal.model.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import site.iblogs.portal.model.params.ContentStatus;
import site.iblogs.portal.model.params.ContentType;

import java.util.Date;

/**
 * 文章API响应实体
 *
 * @author Liu Zhenyu on 3/22/2020
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ContentResponse {
    private Integer id;
    private String title;
    private String slug;
    private Date modified;
    private String content;
    private int hits;
    private ContentType type;
    private String FmtType;
    private String ThumbImg;
    private String Tags;
    private String Categories;
    private ContentStatus Status;
    private int CommentsNum;
    private boolean AllowComment;
    private boolean AllowPing;
    private boolean AllowFeed;
    private String Author;
    private Date Created;
    private Integer Pre;
    private Integer Next;
}
