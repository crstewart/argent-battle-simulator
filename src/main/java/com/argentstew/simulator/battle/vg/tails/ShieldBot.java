package com.argentstew.simulator.battle.vg.tails;

import com.argentstew.simulator.battle.action.AttackAction;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.defense.Guard;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * com.argentstew.simulator.battle.vg.tails
 * 8/26/2019
 *
 * @author Craig
 */
public class ShieldBot extends Guard {

    private static final List<AttackSubType> FAIL_TYPES = Collections.unmodifiableList(Arrays.asList(
            AttackSubType.SLAM, AttackSubType.SMASH, AttackSubType.WATER, AttackSubType.THUNDER, AttackSubType.SHOTGUN,
            AttackSubType.ARMOR_PIERCING
    ));

    public ShieldBot() {
        this.name = "Shield Bot";
        this.description = "Blocks all attacks except for slam, smash, water, thunder, shotgun, rifle, and armor piercing";
        this.initiateMessage = "prepare his Shield Bot!";
        this.successMessage = "successfully defended the attack!";
        this.failureMessage = "failed to defend the attack!";
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
