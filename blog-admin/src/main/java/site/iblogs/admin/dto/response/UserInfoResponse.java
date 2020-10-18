package site.iblogs.admin.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserInfoResponse {
    private Long id;

    private String name;

    private String avatar;

    private String email;
}
