package com.argentstew.simulator.battle.vg.shadow;

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
public class HomingAttack extends MeleeAttack {

    public HomingAttack() {
        super();
        this.name = "Homing Attack";
        this.description = "No additional startup time";
        this.power = 30;
        this.variance = 3;
        this.speed = 0.5;
        this.subtypes = Collections.singletonList(AttackSubType.SLAM);
        this.characteristics = Collections.singletonList(AttackCharacteristic.UNDODGEABLE);
    }

    @Override
    public double calculateSpeed() {
        return this.speed;
    }
}
