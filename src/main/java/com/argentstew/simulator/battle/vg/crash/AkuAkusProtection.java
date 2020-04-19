package com.argentstew.simulator.battle.vg.crash;

import com.argentstew.simulator.battle.action.AttackAction;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.AttackType;
import com.argentstew.simulator.battle.action.defense.Guard;

/**
 * com.argentstew.simulator.battle.vg.crash
 * 8/27/2019
 *
 * @author Craig
 */
public class AkuAkusProtection extends Guard {

    public AkuAkusProtection() {
        this.name = "Aku Aku's Protection";
        this.description = "Blocks all guardable attacks";
        this.initiateMessage = "backs away.";
        this.successMessage = "is protected by Aku Aku!";
        this.failureMessage = "could not be defended from the attack!";
        this.speed = 0.5;
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
