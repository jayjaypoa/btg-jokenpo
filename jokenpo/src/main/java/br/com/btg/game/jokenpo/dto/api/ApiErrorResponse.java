package br.com.btg.game.jokenpo.dto.api;

import br.com.btg.game.jokenpo.exception.enums.EnumJokenpoException;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiErrorResponse<T> extends ApiResponse<T> {

    private EnumJokenpoException error;

    public ApiErrorResponse() {
        super(null);
        this.error = EnumJokenpoException.GENERIC_ERROR;
    }

    public ApiErrorResponse(String errorMessage) {
        super(null);
        this.error = EnumJokenpoException.GENERIC_ERROR;
        this.error.setMessage(errorMessage);
    }

    public ApiErrorResponse(EnumJokenpoException error) {
        super(null);
        this.error = error;
    }

    public EnumJokenpoException getError() {
        return error;
    }

    public void setError(EnumJokenpoException error) {
        this.error = error;
    }

    public void setErrorMessage(String message) {
        this.error.setMessage(message);
    }

}



