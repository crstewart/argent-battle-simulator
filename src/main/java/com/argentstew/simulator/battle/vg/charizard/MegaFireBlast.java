package com.argentstew.simulator.battle.vg.charizard;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedXStrike;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.charizard
 * 9/7/2019
 *
 * @author Craig
 */
public class MegaFireBlast extends RangedXStrike {

    public MegaFireBlast() {
        super();
        this.name = "Mega Fire Blast";
        this.power = 280;
        this.variance = 16;
        this.speed = 6;
        this.subtypes = Collections.singletonList(AttackSubType.FIRE);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNGUARDABLE, AttackCharacteristic.UNDODGEABLE);
    }
}
