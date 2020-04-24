package br.com.btg.game.jokenpo.service;

import br.com.btg.game.jokenpo.dto.MoveRequest;
import br.com.btg.game.jokenpo.dto.MoveResponse;
import br.com.btg.game.jokenpo.exception.JokenpoException;

import java.util.List;

public interface MoveService {

    MoveResponse insert(MoveRequest move) throws JokenpoException;

    List<MoveResponse> getAll() throws JokenpoException;

    List<MoveResponse> deleteByPlayerName(String playerName) throws JokenpoException;

    void clearAll();

}
