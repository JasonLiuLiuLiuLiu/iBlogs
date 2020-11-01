package site.iblogs.common.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import site.iblogs.common.dto.enums.CommentStatus;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CommentResponse {
    private int id;
    private boolean isAuthor;
    private Date created;
    private int cid;
    private String author;
    private int ownerId;
    private String email;
    private String mailPic;
    private String url;
    private String ip;
    private String agent;
    private String content;
    private CommentStatus status;
    private Long parent;
    private List<CommentResponse> children;
}
