package com.argentstew.simulator.battle.action.defense;

import com.argentstew.simulator.battle.action.AttackAction;
import com.argentstew.simulator.battle.action.DefenseAction;
import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.trait.impl.Teleportation;

/**
 * com.argentstew.simulator.battle.action.defense
 * 8/24/2019
 *
 * @author Craig
 */
public abstract class Guard extends DefenseAction {

    @Override
    public boolean isSuccessful(AttackAction attack) {
        if (attack == null) {
            return true;
        }

        if (attack.hasCharacteristic(AttackCharacteristic.UNGUARDABLE)
                || (attack.hasCharacteristic(AttackCharacteristic.HOLD) && !owner.getTraits().has(new Teleportation()))
                || attack.hasCharacteristic(AttackCharacteristic.STEALTH)) {
            return false;
        }

        return doesGuardAttack(attack);
    }

    protected abstract boolean doesGuardAttack(AttackAction attack);
}
