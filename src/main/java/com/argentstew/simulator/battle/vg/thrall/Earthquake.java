package com.argentstew.simulator.battle.vg.thrall;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MagicXStrike;
import com.argentstew.simulator.battle.action.attack.MeleeXStrike;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.thrall
 * 8/24/2019
 *
 * @author Craig
 */
public class Earthquake extends MagicXStrike {

    public Earthquake() {
        super();
        this.name = "Earthquake";
        this.power = 245;
        this.variance = 16;
        this.speed = 4;
        this.subtypes = Collections.singletonList(AttackSubType.EARTH);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNGUARDABLE, AttackCharacteristic.UNDODGEABLE);
    }
}
