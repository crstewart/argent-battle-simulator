package com.argentstew.simulator.battle.vg.ratchet;

import com.argentstew.simulator.battle.action.AttackAction;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;
import com.argentstew.simulator.battle.action.defense.Guard;
import com.argentstew.simulator.battle.vg.common.ReflectedRangedAttack;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * com.argentstew.simulator.battle.vg.ratchet
 * 8/24/2019
 *
 * @author Craig
 */
public class TeslaBarrier extends Guard {

    private static final List<AttackSubType> SUCCESS_TYPES = Collections.unmodifiableList(Arrays.asList(
            AttackSubType.PLASMA, AttackSubType.HANDGUN, AttackSubType.RIFLE, AttackSubType.SHOTGUN,
            AttackSubType.ARMOR_PIERCING, AttackSubType.SLASH, AttackSubType.PIERCE, AttackSubType.HACK,
            AttackSubType.SMASH
    ));

    public TeslaBarrier() {
        this.name = "Tesla Barrier";
        this.description = "Blocks firearm, plasma, and weapon attacks";
        this.initiateMessage = "uses the shield charger!";
        this.successMessage = "successfully defended the attack!";
        this.failureMessage = "failed to block the attack!";
        this.speed = 1;
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

    @Override
    protected boolean doesGuardAttack(AttackAction attack) {
        for (AttackSubType subtype : attack.getSubtypes()) {
            if (SUCCESS_TYPES.contains(subtype)) {
                return true;
            }
        }

        return false;
    }
}
