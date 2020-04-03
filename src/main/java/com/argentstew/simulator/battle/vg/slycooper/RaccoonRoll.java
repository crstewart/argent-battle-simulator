package com.argentstew.simulator.battle.vg.slycooper;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.sly
 * 8/27/2019
 *
 * @author Craig
 */
public class RaccoonRoll extends MeleeAttack {

    public RaccoonRoll() {
        super();
        this.name = "Raccoon Roll";
        this.power = 55;
        this.variance = 6;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.SLAM);
        this.characteristics = Collections.emptyList();
    }
}
