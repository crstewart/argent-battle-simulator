package com.argentstew.simulator.battle.vg.rathalos;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.rathalos
 * 8/27/2019
 *
 * @author Craig
 */
public class SlidingTackle extends MeleeAttack {

    public SlidingTackle() {
        super();
        this.name = "Sliding Tackle";
        this.power = 80;
        this.variance = 8;
        this.speed = 2;
        this.subtypes = Collections.singletonList(AttackSubType.SLAM);
        this.characteristics = Collections.emptyList();
    }
}
