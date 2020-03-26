package com.argentstew.simulator.battle.vg.ness;

import com.argentstew.simulator.battle.action.AttackAction;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;
import com.argentstew.simulator.battle.action.defense.Guard;
import com.argentstew.simulator.battle.vg.common.ReflectedMeleeAttack;

/**
 * com.argentstew.simulator.battle.vg.zelda
 * 8/27/2019
 *
 * @author Craig
 */
public class PsiShieldAlpha extends Guard {

    public static final int MP_COST = 6;

    public PsiShieldAlpha() {
        this.name = "PSI Shield Alpha";
        this.initiateMessage = "tried PSI Shield Alpha!";
        this.successMessage = "was enveloped by a shield!";
        this.failureMessage = "failed to defend the attack!";
        this.speed = 1;
    }

    @Override
    protected boolean doesGuardAttack(AttackAction attack) {
        this.owner.useMagic(MP_COST);
        return attack instanceof MeleeAttack;
    }

    @Override
    public int applyDefense(int damage) {
        return damage / 2;
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
