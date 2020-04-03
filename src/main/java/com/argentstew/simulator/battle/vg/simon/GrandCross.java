package com.argentstew.simulator.battle.vg.simon;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MagicXStrike;
import com.argentstew.simulator.battle.action.attack.RangedXStrike;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.simon
 * 8/24/2019
 *
 * @author Craig
 */
public class GrandCross extends MagicXStrike {

    public GrandCross() {
        super();
        this.name = "Grand Cross";
        this.power = 240;
        this.variance = 15;
        this.speed = 2;
        this.subtypes = Collections.singletonList(AttackSubType.LIGHT);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNGUARDABLE, AttackCharacteristic.UNDODGEABLE);
    }
}
