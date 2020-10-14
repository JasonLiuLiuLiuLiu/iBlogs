package site.iblogs.admin.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class UserInfoResponse {
    private Long id;

    private String username;

    private String email;
}
