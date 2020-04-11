package com.argentstew.simulator.battle.vg.guybrush;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedXStrike;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.guybrush
 * 8/24/2019
 *
 * @author Craig
 */
public class DestructomaticT47 extends RangedXStrike {

    public DestructomaticT47() {
        super();
        this.name = "Destructomatic T-47";
        this.power = 250;
        this.variance = 16;
        this.speed = 6;
        this.subtypes = Collections.singletonList(AttackSubType.SMASH);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNGUARDABLE, AttackCharacteristic.UNDODGEABLE);
    }
}
