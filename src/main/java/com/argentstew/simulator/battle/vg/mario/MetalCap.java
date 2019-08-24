package com.argentstew.simulator.battle.vg.mario;

import com.argentstew.simulator.battle.action.AttackAction;
import com.argentstew.simulator.battle.action.DefenseAction;
import com.argentstew.simulator.battle.action.defense.Guard;

/**
 * com.argentstew.simulator.battle.vg.mario
 * 8/24/2019
 *
 * @author Craig
 */
public class MetalCap extends Guard {

    public MetalCap() {
        this.name = "Metal Cap";
        this.initiateMessage = "puts on his Metal Cap!";
        this.successMessage = "successfully defended the attack!";
        this.failureMessage = "failed to block the attack!";
        this.speed = 2;
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
        return true;
    }
}
