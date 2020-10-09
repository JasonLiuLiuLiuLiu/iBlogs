package site.iblogs.admin.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import site.iblogs.common.model.MetaType;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MetaResponse {
    private Long id;
    private String name;
    private MetaType type;
}
