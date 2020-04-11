package com.argentstew.simulator.battle.vg.doomslayer;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedXStrike;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.doomslayer
 * 8/24/2019
 *
 * @author Craig
 */
public class BFG9000 extends RangedXStrike {

    public BFG9000() {
        super();
        this.name = "BFG 9000";
        this.power = 260;
        this.variance = 12;
        this.speed = 4;
        this.subtypes = Collections.singletonList(AttackSubType.PLASMA);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNGUARDABLE, AttackCharacteristic.UNDODGEABLE);
    }
}
