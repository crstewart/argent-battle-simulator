package com.argentstew.simulator.battle.vg.crash;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.crash
 * 8/27/2019
 *
 * @author Craig
 */
public class BodySlam extends MeleeAttack {

    public BodySlam() {
        super();
        this.name = "Body Slam";
        this.power = 75;
        this.variance = 7;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.SLAM);
        this.characteristics = Collections.emptyList();
    }
}
