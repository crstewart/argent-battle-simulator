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
public class StarGuidance implements Trait {

    private static final int TOTAL_HP = 40;

    private final String name = "Star Guidance";

    private int turnsUntilReady;
    private int blockableDamage;

    public StarGuidance() {
        this.turnsUntilReady = 0;
        this.blockableDamage = TOTAL_HP;
    }

    @Override
    public void setUpTurn() {
        turnsUntilReady = Math.max(turnsUntilReady - 1, 0);
    }

    public boolean isReady() {
        return turnsUntilReady <= 0;
    }

    public void blockDamage(int damage) {
        int damageTaken = damage * 2;
        blockableDamage = Math.max(blockableDamage - damageTaken, 0);
        if (blockableDamage <= 0) {
            turnsUntilReady = 3;
            blockableDamage = TOTAL_HP;
        }
    }

    @Override
    public boolean isImmuneToTorment() {
        return true;
    }
}
