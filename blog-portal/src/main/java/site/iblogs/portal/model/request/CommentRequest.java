package site.iblogs.portal.model.request;

import lombok.Data;

@Data
public class CommentRequest {
    private Integer parentId;
    private int contentId;
    private String author;
    private String mail;
    private String url;
    private String content;
    private String ip;
    private String agent;
}
