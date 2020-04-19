package com.argentstew.simulator.battle.vg.dovahkiin;

import com.argentstew.simulator.battle.action.AttackAction;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.AttackType;
import com.argentstew.simulator.battle.action.defense.Guard;

/**
 * com.argentstew.simulator.battle.vg.dovahkiin
 * 8/27/2019
 *
 * @author Craig
 */
public class SteelShield extends Guard {

    public SteelShield() {
        this.name = "Steel Shield";
        this.description = "Blocks melee and ranged attacks, except for armor piercing moves";
        this.initiateMessage = "readies his Steel Shield";
        this.successMessage = "successfully defended the attack!";
        this.failureMessage = "failed to defend the attack!";
        this.speed = 1.5;
    }

    @Override
    protected boolean doesGuardAttack(AttackAction attack) {
        return !AttackType.MAGIC.equals(attack.getAttackType())
                && !attack.getSubtypes().contains(AttackSubType.ARMOR_PIERCING);
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
