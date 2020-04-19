package com.argentstew.simulator.battle.vg.cuphead;

import com.argentstew.simulator.battle.action.AttackAction;
import com.argentstew.simulator.battle.action.attack.MagicAttack;
import com.argentstew.simulator.battle.action.attack.RangedAttack;
import com.argentstew.simulator.battle.action.defense.Guard;

/**
 * com.argentstew.simulator.battle.vg.cuphead
 * 8/24/2019
 *
 * @author Craig
 */
public class Parry extends Guard {

    public Parry() {
        this.name = "Parry";
        this.description = "Blocks ranged attacks and ranged magic, gains 2 SP on success";
        this.initiateMessage = "attempts to parry the attack!";
        this.successMessage = "parries the attack!";
        this.failureMessage = "was struck by the attack!";
        this.speed = 0;
    }

    @Override
    public int applyDefense(int damage) {
        owner.setMp(Math.min(owner.getMaxMp(), owner.getMp() + 2));
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
        if (attack instanceof MagicAttack) {
            MagicAttack magicAttack = (MagicAttack) attack;
            return !magicAttack.isRequiresMeleeRange();
        }

        return attack instanceof RangedAttack;
    }
}
