package com.argentstew.simulator.battle.action.defense;

import com.argentstew.simulator.battle.action.AttackAction;
import com.argentstew.simulator.battle.action.DefenseAction;
import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.trait.impl.NaturalAgility;
import com.argentstew.simulator.battle.trait.impl.TimeManipulation;
import lombok.EqualsAndHashCode;

/**
 * com.argentstew.simulator.battle.action.defense
 * 8/23/2019
 *
 * @author Craig
 */
@EqualsAndHashCode(callSuper = true)
public class Dodge extends DefenseAction {

    public Dodge() {
        this.setName("Dodge");
        this.setInitiateMessage("attempts to dodge!");
        this.setSuccessMessage("dodges the attack!");
        this.setFailureMessage("fails to dodge the attack!");
        this.setSpeed(0);
    }

    @Override
    public int applyDefense(int damage) {
        return 0;
    }

    @Override
    public AttackAction doCounterAttack(AttackAction attack, int damage) {
        return null;
    }

    @Override
    public boolean isSuccessful(AttackAction attack) {
        if (attack == null) {
            return true;
        }

        if (attack.hasCharacteristic(AttackCharacteristic.UNDODGEABLE)
                || (attack.hasCharacteristic(AttackCharacteristic.HOMING) && !owner.getTraits().has(new TimeManipulation()))
                || attack.hasCharacteristic(AttackCharacteristic.STEALTH)) {
            return false;
        }

        if (attack.hasCharacteristic(AttackCharacteristic.BULLET_SPEED) && !owner.getTraits().has(new NaturalAgility())) {
            return false;
        }

        return Math.random() < (owner.getStats().getSpeed() * 0.0325 + owner.getStats().getAgility() * 0.0575);
    }

    @Override
    public boolean isDoable() {
        return true;
    }
}
