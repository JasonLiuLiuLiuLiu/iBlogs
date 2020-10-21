package site.iblogs.admin.dto.request;

import lombok.Data;
import site.iblogs.common.dto.enums.MetaType;

@Data
public class MetaParam {
    private Long id;
    private String name;
    private MetaType type;
    private String slug;
    private String description;
}
