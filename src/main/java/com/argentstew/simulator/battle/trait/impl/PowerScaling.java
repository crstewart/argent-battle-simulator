package com.argentstew.simulator.battle.trait.impl;

import com.argentstew.simulator.battle.fighter.Fighter;
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
public class PowerScaling implements Trait {

    private final String name = "Power Scaling";
    private final String description = "The fighter does 10% additional damage for every 5 HP the fighter has " +
            "over 150.";

    private double scale;

    @Override
    public void applyStartOfGameEffects(Fighter owner, Fighter defender) {
        int opponentHP = defender.getMaxHp();
        scale = 1.0;
        if (opponentHP > 150) {
            scale += (opponentHP - 150) / 50.0;
        }
    }

    @Override
    public double applyBonusDamage(Fighter defender, double rawDamage) {
        return rawDamage * scale;
    }
}
