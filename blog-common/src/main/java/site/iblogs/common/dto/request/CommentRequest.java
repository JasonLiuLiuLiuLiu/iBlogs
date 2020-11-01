package site.iblogs.common.dto.request;

import lombok.Data;

@Data
public class CommentRequest {
    private Long parentId;
    private Long contentId;
    private String author;
    private String mail;
    private String url;
    private String content;
    private String ip;
    private String agent;
}
