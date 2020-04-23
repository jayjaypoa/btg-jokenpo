package br.com.btg.game.jokenpo.exception;

import br.com.btg.game.jokenpo.exception.enums.EnumJokenpoException;

public class JokenpoException extends Exception {

    public JokenpoException(EnumJokenpoException enumJokenpoException){
        super(enumJokenpoException.getCode());
    }

    public JokenpoException(String errorMessage){
        super(errorMessage);
    }

}
