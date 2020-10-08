package site.iblogs.admin.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OptionResponse {

    private String name;

    private String value;

    private String description;

    private Boolean editable;
}
