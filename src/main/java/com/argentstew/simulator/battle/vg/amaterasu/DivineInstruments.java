package com.argentstew.simulator.battle.vg.amaterasu;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeXStrike;

import java.util.Arrays;

/**
 * com.argentstew.simulator.battle.vg.amaterasu
 * 8/24/2019
 *
 * @author Craig
 */
public class DivineInstruments extends MeleeXStrike {

    public DivineInstruments() {
        super();
        this.name = "Divine Instruments";
        this.power = 275;
        this.variance = 15;
        this.speed = 3;
        this.subtypes = Arrays.asList(AttackSubType.FIRE, AttackSubType.ICE, AttackSubType.THUNDER);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNGUARDABLE, AttackCharacteristic.UNDODGEABLE);
    }
}
