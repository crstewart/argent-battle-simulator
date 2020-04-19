package com.argentstew.simulator.battle.vg.arthur;

import com.argentstew.simulator.battle.action.AttackAction;
import com.argentstew.simulator.battle.action.attack.MagicAttack;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;
import com.argentstew.simulator.battle.action.attack.RangedAttack;
import com.argentstew.simulator.battle.action.defense.Guard;

/**
 * com.argentstew.simulator.battle.vg.arthur
 * 8/27/2019
 *
 * @author Craig
 */
public class ShieldToss extends Guard {

    public ShieldToss() {
        this.name = "Shield Toss";
        this.description = "Blocks ranged attacks and ranged magic, counters melee attacks";
        this.initiateMessage = "throws his shield!";
        this.successMessage = "blocks the attack!";
        this.failureMessage = "failed to stop the attack!";
        this.speed = 1;
    }

    @Override
    protected boolean doesGuardAttack(AttackAction attack) {
        if (attack instanceof RangedAttack) {
            return true;
        }

        if (attack instanceof MagicAttack) {
            return !((MagicAttack) attack).isRequiresMeleeRange();
        }

        return false;
    }

    @Override
    public int applyDefense(int damage) {
        return 0;
    }

    @Override
    public AttackAction doCounterAttack(AttackAction attack, int damage) {
        ThrownShield counterAttack = null;
        if (attack instanceof MeleeAttack) {
            counterAttack = new ThrownShield();
        }

        if (attack instanceof MagicAttack) {
            MagicAttack magicAttack = (MagicAttack) attack;
            if (magicAttack.isRequiresMeleeRange()) {
                counterAttack = new ThrownShield();
            }
        }

        if (counterAttack != null) {
            counterAttack.setOwner(this.owner);
        }

        return counterAttack;
    }

    @Override
    public boolean isDoable() {
        return true;
    }
}
