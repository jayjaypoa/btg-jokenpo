package br.com.btg.game.jokenpo.enums;

import java.util.List;

import static java.util.Arrays.asList;

public enum EnumMovement {

    SPOCK("SPOCK"),
    SCISSORS("TESOURA"),
    PAPER("PAPEL"),
    STONE("PEDRA"),
    LIZARD("LAGARTO");

    private String name;
    private List<EnumMovement> weakness;

    static {
        SPOCK.setWeakness(asList(LIZARD, PAPER));
        SCISSORS.setWeakness(asList(SPOCK, STONE));
        PAPER.setWeakness(asList(SCISSORS, LIZARD));
        STONE.setWeakness(asList(SPOCK, PAPER));
        LIZARD.setWeakness(asList(SCISSORS, STONE));
    }

    EnumMovement(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<EnumMovement> getWeakness() {
        return weakness;
    }

    public void setWeakness(List<EnumMovement> weakness) {
        this.weakness = weakness;
    }
}
