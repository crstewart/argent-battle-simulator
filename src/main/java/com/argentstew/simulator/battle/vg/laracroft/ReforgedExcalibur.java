package com.argentstew.simulator.battle.vg.laracroft;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeXStrike;
import com.argentstew.simulator.battle.action.attack.RangedXStrike;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.laracroft
 * 8/24/2019
 *
 * @author Craig
 */
public class ReforgedExcalibur extends MeleeXStrike {

    public ReforgedExcalibur() {
        super();
        this.name = "Reforged Excalibur";
        this.power = 240;
        this.variance = 14;
        this.speed = 2;
        this.subtypes = Collections.singletonList(AttackSubType.SLASH);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNGUARDABLE, AttackCharacteristic.UNDODGEABLE);
    }
}
