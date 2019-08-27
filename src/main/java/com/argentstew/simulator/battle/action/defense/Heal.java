package com.argentstew.simulator.battle.action.defense;

import com.argentstew.simulator.battle.action.DefenseAction;

/**
 * com.argentstew.simulator.battle.action.defense
 * 8/26/2019
 *
 * @author Craig
 */
public abstract class Heal extends DefenseAction {

    @Override
    public int applyDefense(int damage) {
        return damage;
    }

    public int restoreHealth(int incomingDamage) {
        if (owner.getHp() < incomingDamage || owner.getHp() <= 0) {
            return 0;
        }

        return calculateAmountHealed(incomingDamage);
    }

    protected abstract int calculateAmountHealed(int incomingDamage);
}
