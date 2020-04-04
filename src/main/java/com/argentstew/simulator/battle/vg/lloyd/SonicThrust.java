package com.argentstew.simulator.battle.vg.lloyd;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.lloyd
 * 8/27/2019
 *
 * @author Craig
 */
public class SonicThrust extends MeleeAttack {

    public SonicThrust() {
        super();
        this.name = "Sonic Thrust";
        this.power = 50;
        this.variance = 4;
        this.speed = 0.5;
        this.subtypes = Collections.singletonList(AttackSubType.PIERCE);
        this.characteristics = Collections.emptyList();
    }
}
