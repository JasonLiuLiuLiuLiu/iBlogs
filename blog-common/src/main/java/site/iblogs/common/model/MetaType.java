package site.iblogs.common.model;

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
