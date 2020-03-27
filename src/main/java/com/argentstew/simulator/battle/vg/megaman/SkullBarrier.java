package com.argentstew.simulator.battle.vg.megaman;

import com.argentstew.simulator.battle.action.AttackAction;
import com.argentstew.simulator.battle.action.attack.AttackType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;
import com.argentstew.simulator.battle.action.defense.Guard;

/**
 * com.argentstew.simulator.battle.vg.mario
 * 8/24/2019
 *
 * @author Craig
 */
public class SkullBarrier extends Guard {

    public SkullBarrier() {
        this.name = "Skull Barrier";
        this.initiateMessage = "activates Skull Barrier!";
        this.successMessage = "blocked the attack!";
        this.failureMessage = "was still struck by the attack!";
        this.speed = 1;
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
        return attack instanceof RangedAttack;
    }
}
