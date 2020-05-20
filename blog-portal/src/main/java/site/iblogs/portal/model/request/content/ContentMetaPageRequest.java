package site.iblogs.portal.model.request.content;

import lombok.Data;
import lombok.EqualsAndHashCode;
import site.iblogs.portal.model.request.PageRequest;

@EqualsAndHashCode(callSuper = true)
@Data
public class ContentMetaPageRequest extends PageRequest {
    private String meta;
}
