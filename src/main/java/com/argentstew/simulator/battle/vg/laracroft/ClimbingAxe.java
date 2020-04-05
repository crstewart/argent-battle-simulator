package com.argentstew.simulator.battle.vg.laracroft;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.laracroft
 * 8/27/2019
 *
 * @author Craig
 */
public class ClimbingAxe extends MeleeAttack {

    public ClimbingAxe() {
        super();
        this.name = "Climbing Axe";
        this.power = 50;
        this.variance = 4;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.HACK);
        this.characteristics = Collections.emptyList();
    }
}
