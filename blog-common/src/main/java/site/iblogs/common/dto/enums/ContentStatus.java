package site.iblogs.common.dto.enums;

public enum ContentStatus implements BaseEnum
{
    Draft(0),
    Published(1);

    private Integer code;

    ContentStatus(int code){
        this.code=code;
    }

    @Override
    public Integer getCode() {
        return code;
    }
}
