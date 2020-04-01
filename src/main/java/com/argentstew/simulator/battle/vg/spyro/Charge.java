package com.argentstew.simulator.battle.vg.spyro;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.spyro
 * 8/27/2019
 *
 * @author Craig
 */
public class Charge extends MeleeAttack {

    public Charge() {
        super();
        this.name = "Charge";
        this.power = 75;
        this.variance = 7;
        this.speed = 1;
        this.subtypes = Arrays.asList(AttackSubType.HEADBUTT, AttackSubType.PIERCE);
        this.characteristics = Collections.emptyList();
    }
}
