package br.com.btg.game.jokenpo.service;

import br.com.btg.game.jokenpo.dto.PlayerRequest;
import br.com.btg.game.jokenpo.dto.PlayerResponse;
import br.com.btg.game.jokenpo.entity.PlayerEntity;
import br.com.btg.game.jokenpo.entity.mapper.PlayerMapper;
import br.com.btg.game.jokenpo.exception.JokenpoException;
import br.com.btg.game.jokenpo.repository.PlayerRepository;
import br.com.btg.game.jokenpo.enumeration.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class PlayerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PlayerService.class);

    private PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository){
        this.playerRepository = playerRepository;
    }

    public PlayerResponse insert(PlayerRequest player) throws JokenpoException {
        if(this.verifyIfAlreadyExistsByName(player.getName())){
            LOGGER.error("Player already exists");
            throw new JokenpoException(EnumException.PLAYER_ALREADY_EXISTS);
        }
        LOGGER.debug("Insert new player - Request: " + player.toString());
        PlayerEntity entity = PlayerMapper.requestToEntity(player);
        LOGGER.debug("Inserting player");
        entity = this.playerRepository.save(entity);
/*
System.out.println("AAAAAAAAAAAAAAAAAAAAAAA");
List<EnumMovement> teste = EnumMovement.SPOCK.getWeakness();
for(EnumMovement e : teste){
    System.out.println(e.getName());
}
System.out.println("BBBBBBBBBBBBBBBBBBBBBBB");
*/
        LOGGER.debug("Creating response object");
        return PlayerMapper.entityToResponse(entity);
    }

    public List<PlayerResponse> getAll() throws JokenpoException {
        LOGGER.debug("Finding all players");
        List<PlayerEntity> entityList = this.playerRepository.findAll();
        List<PlayerResponse> response = new ArrayList<>();
        entityList
                .forEach(elem -> {
                    response.add(PlayerMapper.entityToResponse(elem));
                });
        LOGGER.debug("Players filtered");
        return response;
    }

    public PlayerEntity getEntityByName(String name) throws JokenpoException {
        LOGGER.debug("Finding player by name : {}", name);
        return this.playerRepository.findByName(name);
    }

    public List<PlayerResponse> deleteByName(String name) throws JokenpoException {
        if(StringUtils.isEmpty(name)){
            LOGGER.error("Param name invalid");
            throw new JokenpoException(EnumException.INVALID_PARAM);
        }
        LOGGER.debug("Finding player by name : {}", name);
        PlayerEntity entity = this.playerRepository.findByName(name);
        LOGGER.debug("Removing player");
        if(this.playerRepository.delete(entity)){
            return this.getAll();
        }
        LOGGER.error("Error deleting player");
        throw new JokenpoException(EnumException.PLAYER_DELETE_ERROR);
    }

    private Boolean verifyIfAlreadyExistsByName(String name) {
        try {
            if (!Objects.isNull(this.playerRepository.findByName(name))) {
                return true;
            }
        } catch (JokenpoException e) {
            return false;
        }
        return false;
    }

}
