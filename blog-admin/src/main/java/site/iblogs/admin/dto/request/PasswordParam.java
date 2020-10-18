package site.iblogs.admin.dto.request;

import lombok.Data;

@Data
public class PasswordParam {
    private String oldPassword;
    private String newPassword;
}
