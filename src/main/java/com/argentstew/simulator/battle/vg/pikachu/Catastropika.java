package com.argentstew.simulator.battle.vg.pikachu;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedXStrike;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.pikachu
 * 9/7/2019
 *
 * @author Craig
 */
public class Catastropika extends RangedXStrike {

    public Catastropika() {
        super();
        this.name = "Catastropika";
        this.power = 210;
        this.variance = 14;
        this.speed = 3;
        this.subtypes = Collections.singletonList(AttackSubType.THUNDER);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNGUARDABLE, AttackCharacteristic.UNDODGEABLE);
    }
}
