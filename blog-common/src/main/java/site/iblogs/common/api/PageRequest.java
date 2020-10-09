package site.iblogs.common.api;

import lombok.Data;

@Data
public class PageRequest {
    private int pageNum;
    private int pageSize;
}
