package com.argentstew.simulator.battle.vg.pit;

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
public class ThreeSacredTreasures extends RangedXStrike {

    public ThreeSacredTreasures() {
        super();
        this.name = "Three Sacred Treasures";
        this.power = 250;
        this.variance = 14;
        this.speed = 3;
        this.subtypes = Collections.singletonList(AttackSubType.LIGHT);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNGUARDABLE, AttackCharacteristic.UNDODGEABLE);
    }
}
