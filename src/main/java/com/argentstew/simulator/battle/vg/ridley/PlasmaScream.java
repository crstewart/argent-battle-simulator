package com.argentstew.simulator.battle.vg.ridley;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedXStrike;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.ridley
 * 9/15/2019
 *
 * @author Craig
 */
public class PlasmaScream extends RangedXStrike {

    public PlasmaScream() {
        super();
        this.name = "Plasma Scream";
        this.power = 235;
        this.variance = 12;
        this.speed = 4;
        this.subtypes = Collections.singletonList(AttackSubType.PLASMA);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNGUARDABLE, AttackCharacteristic.UNDODGEABLE);
    }
}
