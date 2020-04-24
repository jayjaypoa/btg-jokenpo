package br.com.btg.game.jokenpo.service;

import br.com.btg.game.jokenpo.dto.MoveRequest;
import br.com.btg.game.jokenpo.dto.MoveResponse;
import br.com.btg.game.jokenpo.dto.PlayerResponse;
import br.com.btg.game.jokenpo.entity.MoveEntity;
import br.com.btg.game.jokenpo.entity.PlayerEntity;
import br.com.btg.game.jokenpo.entity.mapper.MoveMapper;
import br.com.btg.game.jokenpo.entity.mapper.PlayerMapper;
import br.com.btg.game.jokenpo.exception.JokenpoException;
import br.com.btg.game.jokenpo.repository.MoveRepository;
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
public class MoveService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MoveService.class);

    private PlayerService playerService;
    private MoveRepository moveRepository;

    @Autowired
    public MoveService(PlayerService playerService, MoveRepository moveRepository){
        this.playerService = playerService;
        this.moveRepository = moveRepository;
    }

    public MoveResponse insert(MoveRequest move) throws JokenpoException {
        if(Objects.isNull(move)
                || StringUtils.isEmpty(move.getPlayerName())
                || StringUtils.isEmpty(move.getMovement())){
            LOGGER.error("Invalid movement");
            throw new JokenpoException(EnumException.MOVEMENT_INVALID);
        }
        LOGGER.debug("Move : {}", move.toString());
        // identify the player
        PlayerEntity playerEntity = this.playerService.getEntityByName(move.getPlayerName());
        // check if exists just one movement for these player
        this.verifyIfAlreadyMoved(playerEntity);
        // identify the movement
        EnumMovement movement = EnumMovement.getEnumMovementByName(move.getMovement());
        if(Objects.isNull(movement)){
            LOGGER.error("Movement not found");
            throw new JokenpoException(EnumException.MOVEMENT_NOT_FOUND);
        }
        // save entity object
        MoveEntity moveEntity = this.moveRepository.save(new MoveEntity(playerEntity, movement));
        // convert entity to response
        return MoveMapper.entityToResponse(moveEntity);
    }

    public List<MoveResponse> getAll() throws JokenpoException {
        LOGGER.debug("Finding all movements");
        List<MoveEntity> entityList = this.moveRepository.findAll();
        List<MoveResponse> response = new ArrayList<>();
        entityList
                .forEach(elem -> {
                    response.add(MoveMapper.entityToResponse(elem));
                });
        LOGGER.debug("Movements searched");
        return response;
    }

/*
    public Boolean deleteByPlayerName(String playerName) throws JokenpoException {
        if(StringUtils.isEmpty(playerName)){
            LOGGER.error("Player name invalid");
            throw new JokenpoException(EnumException.INVALID_PARAM);
        }
        LOGGER.debug("Finding movement by player name : {}", playerName);
        MoveEntity entity = this.moveRepository.findByPlayerName(playerName);
        LOGGER.debug("Removing movement");
        return this.moveRepository.delete(entity);
    }
*/

    private void verifyIfAlreadyMoved(PlayerEntity player) throws JokenpoException {
        long count = this.moveRepository.findAll()
                .stream()
                .filter(elem ->
                        (elem.getPlayer().getName().compareToIgnoreCase(player.getName()) == 0))
                .count();
        if(count > 0){
            LOGGER.error("Movement already exists for these player");
            throw new JokenpoException(EnumException.MOVEMENT_ALREADY_EXISTS);
        }
    }

}
