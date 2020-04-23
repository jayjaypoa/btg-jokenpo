package br.com.btg.game.jokenpo.exception.enums;

import org.springframework.stereotype.Component;

import java.util.Arrays;

public enum EnumJokenpoException {

    GENERIC_ERROR("ERR-0001", "JOKENPO", "GENERIC ERROR", "GENERIC ERROR", "Ocorreu algum erro desconhecido");

    private String code;
    private String origin;
    private String type;
    private String subType;
    private String message;

    EnumJokenpoException(String code, String origin, String type, String subType, String message) {
        this.code = code;
        this.origin = origin;
        this.type = type;
        this.subType = subType;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getOrigin() {
        return origin;
    }

    public String getType() {
        return type;
    }

    public String getSubType() {
        return subType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static EnumJokenpoException getEnumJokenpoExceptionByCode(String code){
        for (EnumJokenpoException elem : Arrays.asList(EnumJokenpoException.values())) {
            if (code.equals(elem.getCode())) {
                return elem;
            }
        }
        return EnumJokenpoException.GENERIC_ERROR;
    }


}
