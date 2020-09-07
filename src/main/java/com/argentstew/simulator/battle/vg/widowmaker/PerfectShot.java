package com.argentstew.simulator.battle.vg.widowmaker;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedXStrike;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.widowmaker
 * 8/24/2019
 *
 * @author Craig
 */
public class PerfectShot extends RangedXStrike {

    public PerfectShot() {
        super();
        this.name = "Perfect Shot";
        this.power = 250;
        this.variance = 12;
        this.speed = 8;
        this.subtypes = Collections.singletonList(AttackSubType.RIFLE);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNGUARDABLE, AttackCharacteristic.UNDODGEABLE);
    }
}
