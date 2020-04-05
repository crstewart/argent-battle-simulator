package com.argentstew.simulator.battle.vg.ryuhayabusa;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.ryuhayabusa
 * 8/27/2019
 *
 * @author Craig
 */
public class FireWheel extends RangedAttack {

    public FireWheel() {
        super();
        this.name = "Fire Wheel";
        this.power = 50;
        this.variance = 5;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.FIRE);
        this.characteristics = Collections.singletonList(AttackCharacteristic.UNDODGEABLE);
    }
}
