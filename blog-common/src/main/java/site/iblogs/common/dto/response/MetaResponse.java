package site.iblogs.common.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import site.iblogs.common.dto.enums.MetaType;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MetaResponse {
    private Long id;
    private String name;
    private MetaType type;
    private String slug;
    private String description;
    private Long count;
}
