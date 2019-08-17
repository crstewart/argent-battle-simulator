package com.argentstew.simulator.battle.fighter;

import lombok.Data;

/**
 * com.argentstew.simulator.battle.fighter
 * 8/17/2019
 *
 * @author Craig
 */
@Data
public class Fighter {

    private String name;
    private int hp;
    private int maxHp;

    public Fighter(String name, int maxHp) {
        this.name = name;
        this.maxHp = maxHp;
        this.hp = maxHp;
    }

    public void attack(Fighter fighter) {
        fighter.hp -= 10;
    }

    @Override
    public String toString() {
        return name + " (" + hp + "/" + maxHp + ")";
    }
}
