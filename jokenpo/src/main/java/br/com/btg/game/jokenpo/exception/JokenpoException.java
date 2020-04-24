package br.com.btg.game.jokenpo.exception;

import br.com.btg.game.jokenpo.enumeration.EnumException;

public class JokenpoException extends Exception {

    public JokenpoException(EnumException enumException){
        super(enumException.getCode() + " - " + enumException.getMessage());
    }

    public JokenpoException(String errorMessage){
        super(errorMessage);
    }

}
