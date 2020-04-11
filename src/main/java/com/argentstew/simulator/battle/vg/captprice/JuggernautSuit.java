package com.argentstew.simulator.battle.vg.captprice;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedXStrike;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.captprice
 * 9/7/2019
 *
 * @author Craig
 */
public class JuggernautSuit extends RangedXStrike {

    public JuggernautSuit() {
        super();
        this.name = "Juggernaut Suit";
        this.power = 240;
        this.variance = 16;
        this.speed = 3;
        this.subtypes = Collections.singletonList(AttackSubType.HANDGUN);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNGUARDABLE, AttackCharacteristic.UNDODGEABLE);
    }
}
