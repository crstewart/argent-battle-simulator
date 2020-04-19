package com.argentstew.simulator.battle.vg.pit;

import com.argentstew.simulator.battle.action.AttackAction;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.AttackType;
import com.argentstew.simulator.battle.action.defense.Guard;

/**
 * com.argentstew.simulator.battle.vg.link
 * 8/27/2019
 *
 * @author Craig
 */
public class GuardianOrbitars extends Guard {

    public GuardianOrbitars() {
        this.name = "Guardian Orbitars";
        this.description = "Blocks all guardable attacks";
        this.initiateMessage = "raises the Guardian Orbitars.";
        this.successMessage = "successfully defended the attack!";
        this.failureMessage = "failed to defend the attack!";
        this.speed = 1.5;
    }

    @Override
    protected boolean doesGuardAttack(AttackAction attack) {
        return true;
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
