package com.argentstew.simulator.battle.vg.gordonfreeman;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedXStrike;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.gordonfreeman
 * 8/24/2019
 *
 * @author Craig
 */
public class TauCannon extends RangedXStrike {

    public TauCannon() {
        super();
        this.name = "Tau Cannon";
        this.power = 230;
        this.variance = 15;
        this.speed = 3;
        this.subtypes = Collections.singletonList(AttackSubType.TOXIC);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNGUARDABLE, AttackCharacteristic.UNDODGEABLE);
    }
}
