package com.argentstew.simulator.battle.vg.erdrick;

import com.argentstew.simulator.battle.action.AttackAction;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;
import com.argentstew.simulator.battle.action.defense.Guard;

/**
 * com.argentstew.simulator.battle.vg.erdrick
 * 8/27/2019
 *
 * @author Craig
 */
public class Kaclang extends Guard {

    public static final int MP_COST = 6;

    public Kaclang() {
        this.name = "Kaclang";
        this.description = "Costs 6 SP, blocks melee attacks";
        this.initiateMessage = "casts Kaclang!";
        this.successMessage = "was immune to the attack!";
        this.failureMessage = "lost their immunity to the attack!";
        this.speed = 1.5;
    }

    @Override
    protected boolean doesGuardAttack(AttackAction attack) {
        this.owner.useMagic(MP_COST);
        return attack instanceof MeleeAttack;
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
        return owner.getMp() >= MP_COST;
    }
}
