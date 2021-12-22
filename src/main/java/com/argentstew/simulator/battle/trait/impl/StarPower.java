package com.argentstew.simulator.battle.trait.impl;

import com.argentstew.simulator.battle.trait.Trait;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * com.argentstew.simulator.battle.trait.impl
 * 11/10/2019
 *
 * @author Craig
 */
@Getter
@EqualsAndHashCode
public class StarPower implements Trait {

    private final String name = "Star Power";
    private final String description = "The fighter chooses a power level from 1 to 3 each turn, affecting the power " +
            "and effects of their moves.";

    private int power;

    @Override
    public void setUpTurn() {
        power = (int) Math.ceil(Math.random() * 3);
    }

    public int getPower() {
        return power;
    }

    @Override
    public boolean isImmuneToTorment() {
        return true;
    }
}
