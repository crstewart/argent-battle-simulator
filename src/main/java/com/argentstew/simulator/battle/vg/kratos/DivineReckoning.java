package com.argentstew.simulator.battle.vg.kratos;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedXStrike;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.kratos
 * 8/24/2019
 *
 * @author Craig
 */
public class DivineReckoning extends RangedXStrike {

    public DivineReckoning() {
        super();
        this.name = "Divine Reckoning";
        this.power = 225;
        this.variance = 15;
        this.speed = 2;
        this.subtypes = Collections.singletonList(AttackSubType.AIR);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNGUARDABLE, AttackCharacteristic.UNDODGEABLE);
    }
}
