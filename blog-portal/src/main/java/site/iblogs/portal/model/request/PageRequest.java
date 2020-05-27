package site.iblogs.portal.model.request;

import lombok.Data;

@Data
public class PageRequest {
    private int pageNum;
    private int pageSize;
}
