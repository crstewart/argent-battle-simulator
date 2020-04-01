package com.argentstew.simulator.battle.vg.spyro;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedXStrike;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.spyro
 * 8/24/2019
 *
 * @author Craig
 */
public class SuperflameBreath extends RangedXStrike {

    public SuperflameBreath() {
        super();
        this.name = "Superflame Breath";
        this.power = 245;
        this.variance = 17;
        this.speed = 3;
        this.subtypes = Collections.singletonList(AttackSubType.FIRE);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNGUARDABLE, AttackCharacteristic.UNDODGEABLE);
    }
}
