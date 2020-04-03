package com.argentstew.simulator.battle.vg.slycooper;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;
import com.argentstew.simulator.battle.fighter.Fighter;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.sly
 * 8/27/2019
 *
 * @author Craig
 */
public class CaneStun extends MeleeAttack {

    public CaneStun() {
        super();
        this.name = "Cane Stun";
        this.power = 45;
        this.variance = 4;
        this.speed = 0.5;
        this.subtypes = Collections.singletonList(AttackSubType.SMASH);
        this.characteristics = Collections.emptyList();
    }

    @Override
    protected double getStunChance(Fighter defender, boolean isCrit) {
        return super.getStunChance(defender, isCrit) * 2;
    }
}
