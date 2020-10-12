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
    private int Id;
    private boolean IsAuthor;
    private Date Created;
    private int Cid;
    private String Author;
    private int OwnerId;
    private String MailPic;
    private String Url;
    private String Ip;
    private String Agent;
    private String Content;
    private CommentStatus Status;
    private int Parent;
    private List<CommentResponse> Children;
}
