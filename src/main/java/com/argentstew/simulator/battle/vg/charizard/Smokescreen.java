package com.argentstew.simulator.battle.vg.charizard;

import com.argentstew.simulator.battle.action.AttackAction;
import com.argentstew.simulator.battle.action.attack.AttackType;
import com.argentstew.simulator.battle.action.defense.Guard;

/**
 * com.argentstew.simulator.battle.vg.charizard
 * 9/8/2019
 *
 * @author Craig
 */
public class Smokescreen extends Guard {

    public Smokescreen() {
        this.name = "Smokescreen";
        this.initiateMessage = "puts up a Smokescreen!";
        this.successMessage = "avoided the attack!";
        this.failureMessage = "failed to avoid the attack!";
        this.speed = 1.5;
    }

    @Override
    protected boolean doesGuardAttack(AttackAction attack) {
        return AttackType.MELEE.equals(attack.getAttackType()) || AttackType.MAGIC.equals(attack.getAttackType());
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
    public boolean isDoable() {
        return true;
    }
}
