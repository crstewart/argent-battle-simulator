package com.argentstew.simulator.battle.vg.kosmos;

import com.argentstew.simulator.battle.action.AttackAction;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.AttackType;
import com.argentstew.simulator.battle.action.attack.MagicAttack;
import com.argentstew.simulator.battle.action.defense.Guard;

/**
 * com.argentstew.simulator.battle.vg.kosmos
 * 8/27/2019
 *
 * @author Craig
 */
public class ForceShield extends Guard {

    public ForceShield() {
        this.name = "Force Shield";
        this.initiateMessage = "readies her Force Shield!";
        this.successMessage = "successfully defended the attack!";
        this.failureMessage = "failed to defend the attack!";
        this.speed = 2;
    }

    @Override
    protected boolean doesGuardAttack(AttackAction attack) {
        return !(attack instanceof MagicAttack);
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
