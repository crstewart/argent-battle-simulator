package com.argentstew.simulator.battle.vg.zero;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedXStrike;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.mario
 * 8/24/2019
 *
 * @author Craig
 */
public class GenmuZero extends RangedXStrike {

    public GenmuZero() {
        super();
        this.name = "Genmu Zero";
        this.power = 230;
        this.variance = 13;
        this.speed = 1;
        this.subtypes = Arrays.asList(AttackSubType.PLASMA, AttackSubType.SLASH);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNGUARDABLE, AttackCharacteristic.UNDODGEABLE);
    }
}
