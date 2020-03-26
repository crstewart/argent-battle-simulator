package com.argentstew.simulator.battle.vg.ness;

import com.argentstew.simulator.battle.action.AttackAction;
import com.argentstew.simulator.battle.action.attack.MagicAttack;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;
import com.argentstew.simulator.battle.action.attack.RangedAttack;
import com.argentstew.simulator.battle.action.defense.Guard;
import com.argentstew.simulator.battle.vg.common.ReflectedMagicAttack;
import com.argentstew.simulator.battle.vg.common.ReflectedMeleeAttack;
import com.argentstew.simulator.battle.vg.common.ReflectedRangedAttack;

/**
 * com.argentstew.simulator.battle.vg.zelda
 * 8/27/2019
 *
 * @author Craig
 */
public class PsiShieldBeta extends Guard {

    public static final int MP_COST = 10;

    public PsiShieldBeta() {
        this.name = "PSI Shield Beta";
        this.initiateMessage = "tried PSI Shield Beta!";
        this.successMessage = "was enveloped by a shield, reflecting the attack!";
        this.failureMessage = "failed to defend the attack!";
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
        AttackAction counterAttack = null;
        if (attack instanceof MeleeAttack) {
            counterAttack = new ReflectedMeleeAttack(attack.getName());
            counterAttack.setOwner(owner);
            counterAttack.setPower(attack.getPower());
            counterAttack.setVariance(attack.getVariance());
            counterAttack.setSpeed(0);
            counterAttack.setSubtypes(attack.getSubtypes());
            counterAttack.setCharacteristics(attack.getCharacteristics());
        }

        return counterAttack;
    }

    @Override
    public boolean isDoable() {
        return owner.getMp() >= MP_COST;
    }
}
