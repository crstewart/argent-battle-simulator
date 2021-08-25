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
public class ExMaverickHunter implements Trait {

    private final String name = "Ex-Maverick Hunter";

    @Override
    public double applyBonusDamage(Fighter defender, double rawDamage) {
        if (defender.getClassifications().contains(FighterClassification.HUMANOID)
                || defender.getClassifications().contains(FighterClassification.MECH)) {
            return rawDamage * 1.2;
        }

        return rawDamage;
    }
}
