package com.argentstew.simulator.battle.vg.palutena;

import com.argentstew.simulator.battle.action.AttackAction;
import com.argentstew.simulator.battle.action.attack.MagicAttack;
import com.argentstew.simulator.battle.action.attack.RangedAttack;
import com.argentstew.simulator.battle.action.defense.Guard;
import com.argentstew.simulator.battle.vg.common.ReflectedMagicAttack;
import com.argentstew.simulator.battle.vg.common.ReflectedRangedAttack;

/**
 * com.argentstew.simulator.battle.vg.palutena
 * 8/27/2019
 *
 * @author Craig
 */
public class ReflectBarrier extends Guard {

    private static final int EQUIP_COST = 8;

    private boolean used = false;

    public ReflectBarrier() {
        this.name = "Reflect Barrier";
        this.description = "Costs 8 SP to equip; reflects ranged attacks and ranged magic";
        this.initiateMessage = "puts up a barrier!";
        this.successMessage = "reflects the attack!";
        this.failureMessage = "failed to defend the attack!";
        this.speed = 0.5;
    }

    @Override
    protected boolean doesGuardAttack(AttackAction attack) {
        if (attack instanceof RangedAttack) {
            return true;
        }

        if (attack instanceof MagicAttack) {
            return !attack.isRequiresMeleeRange();
        }

        return false;
    }

    @Override
    public int applyDefense(int damage) {
        if (!used) {
            used = true;
            owner.useMagic(EQUIP_COST);
        }

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
    public boolean isAllowed() {
        return used || owner.getMp() >= EQUIP_COST;
    }
}
