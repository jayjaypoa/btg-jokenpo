package br.com.btg.game.jokenpo.util;

import br.com.btg.game.jokenpo.entity.PlayerEntity;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

public final class PlayerSingleton {

    private static List<PlayerEntity> INSTANCE;
    private static String INFO = "Player Singleton Instance";

    private PlayerSingleton(){
    }

    public static List<PlayerEntity> getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new ArrayList<PlayerEntity>();
        }
        return INSTANCE;
    }

    public String getInfo() {
        return this.INFO;
    }

}
