package com.argentstew.simulator.battle.vg.deathwing;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.deathwing
 * 8/24/2019
 *
 * @author Craig
 */
public class Onslaught extends MeleeAttack {

    public Onslaught() {
        super();
        this.name = "Onslaught";
        this.power = 90;
        this.variance = 10;
        this.speed = 2.5;
        this.subtypes = Collections.singletonList(AttackSubType.SLAM);
        this.characteristics = Collections.emptyList();
    }
}
