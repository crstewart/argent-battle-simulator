package com.argentstew.simulator.battle.vg.metaknight;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.metaknight
 * 8/24/2019
 *
 * @author Craig
 */
public class DrillRush extends MeleeAttack {

    public DrillRush() {
        super();
        this.name = "Drill Rush";
        this.power = 40;
        this.variance = 8;
        this.speed = 0.5;
        this.subtypes = Arrays.asList(AttackSubType.PIERCE, AttackSubType.ARMOR_PIERCING);
        this.characteristics = Collections.emptyList();
    }
}
