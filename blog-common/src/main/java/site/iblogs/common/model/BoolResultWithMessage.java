package site.iblogs.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class BoolResultWithMessage {

    public BoolResultWithMessage(boolean success) {
        this.success = success;
        message = "";
    }

    public BoolResultWithMessage(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public BoolResultWithMessage() {
        success = false;
        message = "";
    }

    private Boolean success;
    private String message;
}
