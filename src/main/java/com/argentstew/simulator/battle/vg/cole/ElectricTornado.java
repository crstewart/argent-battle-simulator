package com.argentstew.simulator.battle.vg.cole;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedXStrike;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.cole
 * 8/24/2019
 *
 * @author Craig
 */
public class ElectricTornado extends RangedXStrike {

    public ElectricTornado() {
        super();
        this.name = "Electric Tornado";
        this.power = 245;
        this.variance = 12;
        this.speed = 3;
        this.subtypes = Arrays.asList(AttackSubType.AIR, AttackSubType.THUNDER);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNGUARDABLE, AttackCharacteristic.UNDODGEABLE);
    }
}
