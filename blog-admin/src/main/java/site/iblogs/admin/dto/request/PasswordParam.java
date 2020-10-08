package site.iblogs.admin.dto.request;

import lombok.Data;

@Data
public class PasswordParam {
    private String OldPassword;
    private String NewPassword;
}
