package br.com.btg.game.jokenpo.util;

import br.com.btg.game.jokenpo.entity.MoveEntity;

import java.util.ArrayList;
import java.util.List;

public final class MoveSingleton {

    private static List<MoveEntity> MOVE_INSTANCE;
    private static String INFO = "Movement Singleton Instance";

    private MoveSingleton(){
    }

    public static List<MoveEntity> getInstance() {
        if(MOVE_INSTANCE == null) {
            MOVE_INSTANCE = new ArrayList<MoveEntity>();
        }
        return MOVE_INSTANCE;
    }

    public String getInfo() {
        return this.INFO;
    }

}
