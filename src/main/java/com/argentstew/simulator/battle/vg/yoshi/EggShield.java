package com.argentstew.simulator.battle.vg.yoshi;

import com.argentstew.simulator.battle.action.AttackAction;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.defense.Guard;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * com.argentstew.simulator.battle.vg.yoshi
 * 8/26/2019
 *
 * @author Craig
 */
public class EggShield extends Guard {

    private static final List<AttackSubType> FAIL_TYPES = Collections.unmodifiableList(Arrays.asList(
            AttackSubType.SLAM, AttackSubType.PIERCE, AttackSubType.HACK, AttackSubType.SMASH,
            AttackSubType.ARMOR_PIERCING
    ));

    public EggShield() {
        this.name = "Egg Shield";
        this.description = "Blocks all attacks except for slam, pierce, hack, smash, and armor piercing";
        this.initiateMessage = "retreats into his Egg Shield";
        this.successMessage = "successfully defended the attack!";
        this.failureMessage = "has his egg cracked by the attack!";
        this.speed = 1;
    }

    @Override
    protected boolean doesGuardAttack(AttackAction attack) {
        for (AttackSubType subtype : attack.getSubtypes()) {
            if (FAIL_TYPES.contains(subtype)) {
                return false;
            }
        }

        return true;
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
