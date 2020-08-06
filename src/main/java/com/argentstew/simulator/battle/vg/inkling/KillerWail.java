package com.argentstew.simulator.battle.vg.inkling;

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
public class KillerWail extends RangedXStrike {

    public KillerWail() {
        super();
        this.name = "Killer Wail";
        this.power = 250;
        this.variance = 25;
        this.speed = 1.5;
        this.subtypes = Collections.singletonList(AttackSubType.SOUND);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNGUARDABLE, AttackCharacteristic.UNDODGEABLE);
    }
}
