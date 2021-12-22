package com.argentstew.simulator.battle.trait.impl;

import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.fighter.FighterClassification;
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
public class MonsterSlayer implements Trait {

    private final String name = "Monster Slayer";
    private final String description = "The fighter does 50% additional damage to monster characters.";

    @Override
    public double applyBonusDamage(Fighter defender, double rawDamage) {
        if (defender.getClassifications().contains(FighterClassification.MONSTER)) {
            return rawDamage * 1.5;
        }

        return rawDamage;
    }
}
