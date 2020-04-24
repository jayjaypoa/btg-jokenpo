package br.com.btg.game.jokenpo.service;

import br.com.btg.game.jokenpo.dto.PlayerRequest;
import br.com.btg.game.jokenpo.dto.PlayerResponse;
import br.com.btg.game.jokenpo.entity.PlayerEntity;
import br.com.btg.game.jokenpo.exception.JokenpoException;

import java.util.List;

public interface PlayerService {

    PlayerResponse insert(PlayerRequest player) throws JokenpoException;

    List<PlayerResponse> getAll() throws JokenpoException;

    PlayerEntity getEntityByName(String name) throws JokenpoException;

    List<PlayerResponse> deleteByName(String name) throws JokenpoException;

    void clearAll();

}
