package com.argentstew.simulator.battle.vg.rathalos;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.rathalos
 * 8/27/2019
 *
 * @author Craig
 */
public class PoisonClaw extends MeleeAttack {

    public PoisonClaw() {
        super();
        this.name = "Poison Claw";
        this.power = 60;
        this.variance = 10;
        this.speed = 1.5;
        this.subtypes = Arrays.asList(AttackSubType.CLAW, AttackSubType.TOXIC);
        this.characteristics = Collections.emptyList();
    }
}
