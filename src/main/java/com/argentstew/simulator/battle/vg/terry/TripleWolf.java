package com.argentstew.simulator.battle.vg.terry;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedXStrike;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.terry
 * 8/24/2019
 *
 * @author Craig
 */
public class TripleWolf extends RangedXStrike {

    public TripleWolf() {
        super();
        this.name = "Triple Wolf";
        this.power = 240;
        this.variance = 14;
        this.speed = 2.5;
        this.subtypes = Collections.singletonList(AttackSubType.CHI);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNGUARDABLE, AttackCharacteristic.UNDODGEABLE);
    }
}
