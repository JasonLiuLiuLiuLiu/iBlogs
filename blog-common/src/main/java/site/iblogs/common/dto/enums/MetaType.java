package site.iblogs.common.dto.enums;

import site.iblogs.common.dto.enums.BaseEnum;

public enum MetaType implements BaseEnum {
    Tag(0),
    Category(1);
    private Integer code;

    MetaType(int code) {
        this.code = code;
    }
    @Override
    public Integer getCode() {
        return code;
    }
}
