package site.iblogs.portal.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MetaDataResponse {
    private String name;
    private int count;
}
