package site.iblogs.common.api;

import lombok.Data;

@Data
public class PageParam {
    private int index;
    private int limit;
    private String orderBy;
    private OrderType orderType;
}
