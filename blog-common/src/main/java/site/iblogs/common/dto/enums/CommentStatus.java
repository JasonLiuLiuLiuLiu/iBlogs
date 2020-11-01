package site.iblogs.common.dto.enums;

public enum CommentStatus implements BaseEnum {
    Pending(0),
    Approved(1);

    private Integer code;

    CommentStatus(int code){
        this.code=code;
    }

    @Override
    public Integer getCode() {
        return code;
    }
}
