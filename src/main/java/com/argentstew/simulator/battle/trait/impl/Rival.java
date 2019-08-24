package com.argentstew.simulator.battle.trait.impl;

import com.argentstew.simulator.battle.action.AttackAction;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.trait.Trait;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * com.argentstew.simulator.battle.trait.impl
 * 8/24/2019
 *
 * @author Craig
 */
@Data
@AllArgsConstructor
public class Rival implements Trait {

    private String rivalName;
    private double damageMultiplier;

    @Override
    public String getName() {
        return rivalName + " Rival";
    }

    @Override
    public double applyBonusDamage(Fighter defender, double rawDamage) {
        if (defender.getName().equals(rivalName)) {
            return rawDamage * damageMultiplier;
        }

        return rawDamage;
    }

    @Override
    public AttackAction applyPassiveDefense(AttackAction attack) {
        return null;
    }
}
