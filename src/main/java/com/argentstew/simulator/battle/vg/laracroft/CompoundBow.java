package com.argentstew.simulator.battle.vg.laracroft;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;
import com.argentstew.simulator.battle.action.attack.RangedAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.laracroft
 * 8/27/2019
 *
 * @author Craig
 */
public class CompoundBow extends RangedAttack {

    public CompoundBow() {
        super();
        this.name = "Compound Bow";
        this.power = 55;
        this.variance = 5;
        this.speed = 1.5;
        this.subtypes = Collections.singletonList(AttackSubType.PIERCE);
        this.characteristics = Collections.emptyList();
    }
}
