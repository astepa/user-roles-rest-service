package app.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.validation.FieldError;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ApiBodyResponse implements Serializable {

    private boolean success;
    private List<CustomError> errors;

    public ApiBodyResponse(boolean success) {
        this.success = success;
    }

    public ApiBodyResponse(boolean success, List<CustomError> errors) {
        this.success = success;
        this.errors = errors;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<CustomError> getErrors() {
        return errors;
    }

    public void setErrors(List<CustomError> errors) {
        this.errors = errors;
    }

    public void addError(FieldError field, String errorMessage) {
        if (this.errors == null) this.errors = new ArrayList<>();
        CustomError error = new CustomError(field, errorMessage);
        errors.add(error);
    }
}
