package site.iblogs.admin.dto.request;

import lombok.Data;
import site.iblogs.common.model.MetaType;

@Data
public class MetaParam {
    private Long id;
    private String name;
    private MetaType type;
}
