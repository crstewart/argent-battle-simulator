package com.argentstew.simulator.battle.vg.luigi;

import com.argentstew.simulator.battle.action.AttackAction;
import com.argentstew.simulator.battle.action.attack.AttackType;
import com.argentstew.simulator.battle.action.defense.Guard;

/**
 * com.argentstew.simulator.battle.vg.mario
 * 8/24/2019
 *
 * @author Craig
 */
public class VanishCap extends Guard {

    public VanishCap() {
        this.name = "Vanish Cap";
        this.initiateMessage = "puts on his Vanish Cap!";
        this.successMessage = "phased through the attack!";
        this.failureMessage = "was still struck by the attack!";
        this.speed = 1.5;
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

    @Override
    protected boolean doesGuardAttack(AttackAction attack) {
        return !AttackType.MAGIC.equals(attack.getAttackType());
    }
}
