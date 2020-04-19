package com.argentstew.simulator.battle.vg.sonic;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.sonic
 * 8/27/2019
 *
 * @author Craig
 */
public class WindUpPunch extends MeleeAttack {

    public WindUpPunch() {
        super();
        this.name = "Wind-Up Punch";
        this.description = "No additional startup time";
        this.power = 55;
        this.variance = 6;
        this.speed = 1.5;
        this.subtypes = Collections.singletonList(AttackSubType.PUNCH);
        this.characteristics = Collections.emptyList();
    }

    @Override
    public double calculateSpeed() {
        return this.speed;
    }
}
