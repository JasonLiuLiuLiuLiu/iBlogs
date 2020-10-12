package site.iblogs.common.dto.enums;

public enum ContentType implements BaseEnum
{
    Post(0),
    Page(1);

    private Integer code;

    ContentType(int code){
        this.code=code;
    }

    @Override
    public Integer getCode() {
        return code;
    }
}

