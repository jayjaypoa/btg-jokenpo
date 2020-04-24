package br.com.btg.game.jokenpo.dto.api;

import br.com.btg.game.jokenpo.enumeration.EnumException;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiErrorResponse<T> extends ApiResponse<T> {

    private EnumException error;

    public ApiErrorResponse() {
        super(null);
        this.error = EnumException.GENERIC_ERROR;
    }

    public ApiErrorResponse(String errorMessage) {
        super(null);
        this.error = EnumException.GENERIC_ERROR;
        this.error.setMessage(errorMessage);
    }

    public ApiErrorResponse(EnumException error) {
        super(null);
        this.error = error;
    }

    public EnumException getError() {
        return error;
    }

    public void setError(EnumException error) {
        this.error = error;
    }

    public void setErrorMessage(String message) {
        this.error.setMessage(message);
    }

}



