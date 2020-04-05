package com.argentstew.simulator.battle.vg.subzero;

import com.argentstew.simulator.battle.action.Action;
import com.argentstew.simulator.battle.action.AttackAction;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;
import com.argentstew.simulator.battle.action.defense.Guard;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * com.argentstew.simulator.battle.vg.subzero
 * 8/27/2019
 *
 * @author Craig
 */
public class IcyCounter extends Guard {

    private static final List<AttackSubType> SUCCESS_TYPES = Collections.unmodifiableList(Arrays.asList(
            AttackSubType.PUNCH, AttackSubType.HEADBUTT, AttackSubType.CLAW, AttackSubType.BITE,
            AttackSubType.SLAM
    ));

    public IcyCounter() {
        this.name = "Icy Counter";
        this.initiateMessage = "covers himself in ice!";
        this.successMessage = "defends against the attack!";
        this.failureMessage = "failed to defend the attack!";
        this.speed = 1;
    }

    @Override
    protected boolean doesGuardAttack(AttackAction attack) {
        return attack instanceof MeleeAttack;
    }

    @Override
    public int applyDefense(int damage) {
        return 0;
    }

    @Override
    public AttackAction doCounterAttack(AttackAction attack, int damage) {
        for (AttackSubType subType : attack.getSubtypes()) {
            if (SUCCESS_TYPES.contains(subType)) {
                AttackAction counter = new KoriBlade();
                counter.setOwner(owner);
                return counter;
            }
        }

        return null;
    }

    @Override
    public boolean isDoable() {
        return true;
    }
}
