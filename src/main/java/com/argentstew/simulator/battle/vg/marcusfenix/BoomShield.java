package com.argentstew.simulator.battle.vg.marcusfenix;

import com.argentstew.simulator.battle.action.AttackAction;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.defense.Guard;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * com.argentstew.simulator.battle.vg.marcusfenix
 * 8/24/2019
 *
 * @author Craig
 */
public class BoomShield extends Guard {

    private static final List<AttackSubType> SUCCESS_TYPES = Collections.unmodifiableList(Arrays.asList(
            AttackSubType.PLASMA, AttackSubType.HANDGUN, AttackSubType.RIFLE, AttackSubType.SHOTGUN,
            AttackSubType.EXPLOSIVE
    ));

    public BoomShield() {
        this.name = "Boom Shield";
        this.initiateMessage = "readies his Boom Shield!";
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
