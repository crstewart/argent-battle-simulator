package com.argentstew.simulator.battle.vg.kingdedede;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedXStrike;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.mario
 * 8/24/2019
 *
 * @author Craig
 */
public class DedeRush extends RangedXStrike {

    public DedeRush() {
        super();
        this.name = "Dede-Rush";
        this.power = 240;
        this.variance = 16;
        this.speed = 1;
        this.subtypes = Arrays.asList(AttackSubType.EXPLOSIVE, AttackSubType.SMASH);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNGUARDABLE, AttackCharacteristic.UNDODGEABLE);
    }
}
