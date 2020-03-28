package com.argentstew.simulator.battle.vg.tronbonne;

import com.argentstew.simulator.battle.action.AttackAction;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.defense.Guard;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * com.argentstew.simulator.battle.vg.tronbonne
 * 8/26/2019
 *
 * @author Craig
 */
public class GustaffShield extends Guard {

    public GustaffShield() {
        this.name = "Gustaff Shield";
        this.initiateMessage = "raises the shield of her mech!";
        this.successMessage = "successfully defended the attack!";
        this.failureMessage = "failed to block the attack!";
        this.speed = 1.5;
    }

    @Override
    protected boolean doesGuardAttack(AttackAction attack) {
        return !attack.getSubtypes().contains(AttackSubType.ARMOR_PIERCING);
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
