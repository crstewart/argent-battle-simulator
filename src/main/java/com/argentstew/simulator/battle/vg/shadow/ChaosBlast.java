package com.argentstew.simulator.battle.vg.shadow;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeXStrike;
import com.argentstew.simulator.battle.action.attack.RangedXStrike;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.shadiw
 * 8/24/2019
 *
 * @author Craig
 */
public class ChaosBlast extends RangedXStrike {

    public ChaosBlast() {
        super();
        this.name = "Chaos Blast";
        this.power = 300;
        this.variance = 10;
        this.speed = 6;
        this.subtypes = Arrays.asList(AttackSubType.DARK, AttackSubType.GRAVITY);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNGUARDABLE, AttackCharacteristic.UNDODGEABLE);
    }
}
