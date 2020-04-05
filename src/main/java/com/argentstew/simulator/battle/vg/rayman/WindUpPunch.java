package com.argentstew.simulator.battle.vg.rayman;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.rayman
 * 8/24/2019
 *
 * @author Craig
 */
public class WindUpPunch extends MeleeAttack {

    public WindUpPunch() {
        super();
        this.name = "Wind-Up Punch";
        this.power = 90;
        this.variance = 9;
        this.speed = 2.5;
        this.subtypes = Collections.singletonList(AttackSubType.PUNCH);
        this.characteristics = Collections.emptyList();
    }
}
