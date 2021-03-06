package com.argentstew.simulator.battle.vg.pit;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;
import com.argentstew.simulator.battle.fighter.Fighter;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.pit
 * 8/27/2019
 *
 * @author Craig
 */
public class InsightStaff extends RangedAttack {

    public InsightStaff() {
        super();
        this.name = "Insight Staff";
        this.description = "Does 50% damage at melee range, 200% damage at maximum range";
        this.power = 50;
        this.variance = 5;
        this.speed = 1.5;
        this.subtypes = Collections.singletonList(AttackSubType.PIERCE);
        this.characteristics = Collections.emptyList();
    }

    @Override
    protected double getBaseDamage() {
        double baseDamage = super.getBaseDamage();
        double distanceBetweenFighters = owner.getArena().getDistanceBetweenFighters();
        return baseDamage * (distanceBetweenFighters / 2.0);
    }
}
