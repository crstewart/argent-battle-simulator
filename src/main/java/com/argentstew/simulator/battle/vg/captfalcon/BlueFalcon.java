package com.argentstew.simulator.battle.vg.captfalcon;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeXStrike;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.captfalcon
 * 8/27/2019
 *
 * @author Craig
 */
public class BlueFalcon extends MeleeXStrike {

    public BlueFalcon() {
        super();
        this.name = "Blue Falcon";
        this.power = 300;
        this.variance = 18;
        this.speed = 2;
        this.subtypes = Collections.singletonList(AttackSubType.SMASH);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNGUARDABLE, AttackCharacteristic.UNDODGEABLE);
    }
}
