package com.argentstew.simulator.battle.vg.dante;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeXStrike;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.ryu
 * 8/24/2019
 *
 * @author Craig
 */
public class FinaleStinger extends MeleeXStrike {

    public FinaleStinger() {
        super();
        this.name = "Finale Stinger";
        this.power = 220;
        this.variance = 18;
        this.speed = 2;
        this.subtypes = Collections.singletonList(AttackSubType.PIERCE);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNGUARDABLE, AttackCharacteristic.UNDODGEABLE);
    }
}
