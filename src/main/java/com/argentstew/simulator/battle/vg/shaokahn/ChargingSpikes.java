package com.argentstew.simulator.battle.vg.shaokahn;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.shaokahn
 * 8/27/2019
 *
 * @author Craig
 */
public class ChargingSpikes extends MeleeAttack {

    public ChargingSpikes() {
        super();
        this.name = "Charging Spikes";
        this.power = 80;
        this.variance = 4;
        this.speed = 1;
        this.subtypes = Arrays.asList(AttackSubType.SLAM, AttackSubType.PIERCE);
        this.characteristics = Collections.emptyList();
    }
}
