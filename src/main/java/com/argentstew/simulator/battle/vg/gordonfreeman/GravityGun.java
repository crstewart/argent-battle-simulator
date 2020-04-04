package com.argentstew.simulator.battle.vg.gordonfreeman;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.gordonfreeman
 * 8/27/2019
 *
 * @author Craig
 */
public class GravityGun extends MeleeAttack {

    public GravityGun() {
        super();
        this.name = "Gravity Gun";
        this.power = 50;
        this.variance = 5;
        this.speed = 1;
        this.subtypes = Collections.emptyList();
        this.characteristics = Collections.singletonList(AttackCharacteristic.UNGUARDABLE);
    }
}
