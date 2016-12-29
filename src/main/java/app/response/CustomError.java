package app.response;

import org.springframework.validation.FieldError;

import java.io.Serializable;

public class CustomError implements Serializable {
    String objectName;
    String field;
    String code;
    String message;

    public CustomError(String objectName, String field, String code, String message) {
        this.objectName = objectName;
        this.field = field;
        this.code = code;
        this.message = message;
    }

    public CustomError(FieldError fieldError, String errorMessage) {
        this.objectName = fieldError.getObjectName();
        this.field = fieldError.getField();
        this.code = fieldError.getCode();
        this.message = errorMessage;
    }

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
