package com.argentstew.simulator.battle.vg.mallow;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MagicXStrike;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.mallow
 * 8/24/2019
 *
 * @author Craig
 */
public class StarRain extends MagicXStrike {

    public StarRain() {
        super();
        this.name = "Star Rain";
        this.power = 240;
        this.variance = 18;
        this.speed = 3;
        this.subtypes = Collections.singletonList(AttackSubType.LIGHT);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNDODGEABLE, AttackCharacteristic.UNGUARDABLE);
    }
}
