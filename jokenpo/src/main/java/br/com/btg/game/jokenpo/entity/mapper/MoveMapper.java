package br.com.btg.game.jokenpo.entity.mapper;

import br.com.btg.game.jokenpo.dto.MoveRequest;
import br.com.btg.game.jokenpo.dto.MoveResponse;
import br.com.btg.game.jokenpo.dto.PlayerRequest;
import br.com.btg.game.jokenpo.dto.PlayerResponse;
import br.com.btg.game.jokenpo.entity.MoveEntity;
import br.com.btg.game.jokenpo.entity.PlayerEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MoveMapper {

    private static final Logger LOGGER = LoggerFactory.getLogger(MoveMapper.class);

    private static ModelMapper MAPPER = new ModelMapper();

    public static MoveEntity requestToEntity(MoveRequest moveRequest){
        LOGGER.debug("Converting: request object to entity object");
        return MAPPER.map(moveRequest, MoveEntity.class);
    }

    public static MoveResponse entityToResponse(MoveEntity entity) {
        LOGGER.debug("Converting: entity object to response object");
        MoveResponse response = MAPPER.map(entity, MoveResponse.class);
        response.setMovement(entity.getEnumMovement());
        return response;
    }

}
