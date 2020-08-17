package com.argentstew.simulator.battle.vg.marth;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.marth
 * 8/27/2019
 *
 * @author Craig
 */
public class Rapier extends MeleeAttack {

    public Rapier() {
        super();
        this.name = "Rapier";
        this.power = 50;
        this.variance = 5;
        this.speed = 1;
        this.subtypes = Arrays.asList(AttackSubType.PIERCE, AttackSubType.ARMOR_PIERCING);
        this.characteristics = Collections.emptyList();
    }
}
