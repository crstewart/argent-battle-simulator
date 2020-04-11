package com.argentstew.simulator.battle.vg.draven;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedXStrike;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.draven
 * 8/24/2019
 *
 * @author Craig
 */
public class WhirlingDeath extends RangedXStrike {

    public WhirlingDeath() {
        super();
        this.name = "Whirling Death";
        this.power = 240;
        this.variance = 14;
        this.speed = 1.5;
        this.subtypes = Collections.singletonList(AttackSubType.HACK);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNGUARDABLE, AttackCharacteristic.UNDODGEABLE);
    }
}
