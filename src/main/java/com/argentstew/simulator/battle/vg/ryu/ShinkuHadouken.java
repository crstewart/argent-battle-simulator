package com.argentstew.simulator.battle.vg.ryu;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedXStrike;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.ryu
 * 8/24/2019
 *
 * @author Craig
 */
public class ShinkuHadouken extends RangedXStrike {

    public ShinkuHadouken() {
        super();
        this.name = "Shinku Hadouken";
        this.power = 240;
        this.variance = 13;
        this.speed = 2;
        this.subtypes = Collections.singletonList(AttackSubType.CHI);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNGUARDABLE, AttackCharacteristic.UNDODGEABLE);
    }
}
