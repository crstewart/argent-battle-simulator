package com.argentstew.simulator.battle.vg.fox;

import com.argentstew.simulator.battle.action.AttackAction;
import com.argentstew.simulator.battle.action.attack.MagicAttack;
import com.argentstew.simulator.battle.action.attack.RangedAttack;
import com.argentstew.simulator.battle.action.defense.Guard;
import com.argentstew.simulator.battle.vg.common.ReflectedMagicAttack;
import com.argentstew.simulator.battle.vg.common.ReflectedRangedAttack;

/**
 * com.argentstew.simulator.battle.vg.zelda
 * 8/27/2019
 *
 * @author Craig
 */
public class Reflector extends Guard {

    public Reflector() {
        this.name = "Reflector";
        this.description = "Reflects all guardable ranged attacks and ranged magic";
        this.initiateMessage = "pulls out his Reflector";
        this.successMessage = "reflects the attack!";
        this.failureMessage = "failed to reflect the attack!";
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
        AttackAction counterAttack = null;
        if (attack instanceof RangedAttack) {
            counterAttack = new ReflectedRangedAttack(attack.getName());
            counterAttack.setOwner(owner);
            counterAttack.setPower(attack.getPower());
            counterAttack.setVariance(attack.getVariance());
            counterAttack.setSpeed(0);
            counterAttack.setSubtypes(attack.getSubtypes());
            counterAttack.setCharacteristics(attack.getCharacteristics());
        } else if (attack instanceof MagicAttack) {
            counterAttack = new ReflectedMagicAttack(attack.getName());
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
        return true;
    }
}
