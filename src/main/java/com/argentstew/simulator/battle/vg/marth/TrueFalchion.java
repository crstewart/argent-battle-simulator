package com.argentstew.simulator.battle.vg.marth;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeXStrike;

import java.util.Arrays;

/**
 * com.argentstew.simulator.battle.vg.marth
 * 8/27/2019
 *
 * @author Craig
 */
public class TrueFalchion extends MeleeXStrike {

    public TrueFalchion() {
        super();
        this.name = "True Falchion";
        this.power = 225;
        this.variance = 15;
        this.speed = 1;
        this.subtypes = Arrays.asList(AttackSubType.SLASH, AttackSubType.LIGHT);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNGUARDABLE, AttackCharacteristic.UNDODGEABLE);
    }
}
