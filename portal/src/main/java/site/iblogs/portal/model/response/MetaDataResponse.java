package site.iblogs.portal.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MetaDataResponse {
    public int total;
    public Map<String,Integer> data;
}
