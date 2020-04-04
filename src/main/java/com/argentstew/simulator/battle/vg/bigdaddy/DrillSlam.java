package com.argentstew.simulator.battle.vg.bigdaddy;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.bigdaddy
 * 8/27/2019
 *
 * @author Craig
 */
public class DrillSlam extends MeleeAttack {

    public DrillSlam() {
        super();
        this.name = "Drill Slam";
        this.power = 60;
        this.variance = 5;
        this.speed = 2;
        this.subtypes = Collections.singletonList(AttackSubType.EARTH);
        this.characteristics = Collections.emptyList();
    }
}
