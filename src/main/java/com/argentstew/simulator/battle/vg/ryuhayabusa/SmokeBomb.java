package com.argentstew.simulator.battle.vg.ryuhayabusa;

import com.argentstew.simulator.battle.action.AttackAction;
import com.argentstew.simulator.battle.action.attack.AttackType;
import com.argentstew.simulator.battle.action.defense.Guard;

/**
 * com.argentstew.simulator.battle.vg.ryuhayabusa
 * 9/8/2019
 *
 * @author Craig
 */
public class SmokeBomb extends Guard {

    public SmokeBomb() {
        this.name = "Smoke Bomb";
        this.description = "Makes melee and magic attacks miss";
        this.initiateMessage = "sets off a Smoke Bomb!";
        this.successMessage = "avoided the attack!";
        this.failureMessage = "failed to avoid the attack!";
        this.speed = 0.5;
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
