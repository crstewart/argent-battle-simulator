package com.argentstew.simulator.battle.vg.luigi;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedXStrike;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.luigi
 * 8/24/2019
 *
 * @author Craig
 */
public class Poultergust extends RangedXStrike {

    public Poultergust() {
        super();
        this.name = "Poultergust";
        this.power = 250;
        this.variance = 20;
        this.speed = 0.5;
        this.subtypes = Collections.singletonList(AttackSubType.AIR);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNGUARDABLE, AttackCharacteristic.UNDODGEABLE);
    }
}
