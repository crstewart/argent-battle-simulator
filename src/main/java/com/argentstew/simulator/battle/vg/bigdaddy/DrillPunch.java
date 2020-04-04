package com.argentstew.simulator.battle.vg.bigdaddy;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.bigdaddy
 * 8/27/2019
 *
 * @author Craig
 */
public class DrillPunch extends MeleeAttack {

    public DrillPunch() {
        super();
        this.name = "Drill Punch";
        this.power = 50;
        this.variance = 4;
        this.speed = 1.5;
        this.subtypes = Arrays.asList(AttackSubType.PIERCE, AttackSubType.ARMOR_PIERCING);
        this.characteristics = Collections.emptyList();
    }
}
