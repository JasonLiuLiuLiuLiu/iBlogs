package site.iblogs.admin.dto.request;

import lombok.Data;

@Data
public class RegisterParam {
    private String Username;
    private String Password;
    private String Email;
}
