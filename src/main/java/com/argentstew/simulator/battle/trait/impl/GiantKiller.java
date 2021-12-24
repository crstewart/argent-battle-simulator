package com.argentstew.simulator.battle.trait.impl;

import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.fighter.FighterStats;
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
public class GiantKiller implements Trait {

    private static final int GIANT_SIZE_MIN = 6;

    private final String name = "Giant Killer";
    private final String description = "The fighter does 30% additional damage to characters of size 6 or higher, " +
            "dealing an additional 5% damage for every 0.5 size over that value.";

    @Override
    public double applyBonusDamage(Fighter defender, double rawDamage) {
        double damageMultiplier = 1;
        if (defender.getStat(FighterStats.SIZE) >= GIANT_SIZE_MIN) {
            damageMultiplier = 1.3 + (defender.getStat(FighterStats.SIZE) - GIANT_SIZE_MIN);
        }

        return rawDamage * damageMultiplier;
    }
}
