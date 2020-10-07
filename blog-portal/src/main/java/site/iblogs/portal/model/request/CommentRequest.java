package site.iblogs.portal.model.request;

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
