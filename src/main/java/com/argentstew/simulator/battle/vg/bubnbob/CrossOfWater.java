package com.argentstew.simulator.battle.vg.bubnbob;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedXStrike;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.bubnbob
 * 8/24/2019
 *
 * @author Craig
 */
public class CrossOfWater extends RangedXStrike {

    public CrossOfWater() {
        super();
        this.name = "Cross of Water";
        this.power = 360;
        this.variance = 20;
        this.speed = 8;
        this.subtypes = Collections.singletonList(AttackSubType.WATER);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNGUARDABLE, AttackCharacteristic.UNDODGEABLE);
    }
}
