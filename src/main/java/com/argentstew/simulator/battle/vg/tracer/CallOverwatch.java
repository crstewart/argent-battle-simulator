package com.argentstew.simulator.battle.vg.tracer;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedXStrike;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.tracer
 * 8/24/2019
 *
 * @author Craig
 */
public class CallOverwatch extends RangedXStrike {

    public CallOverwatch() {
        super();
        this.name = "Call Team Overwatch";
        this.power = 230;
        this.variance = 15;
        this.speed = 5;
        this.subtypes = Arrays.asList(AttackSubType.PLASMA, AttackSubType.RIFLE, AttackSubType.ASSIST);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNGUARDABLE, AttackCharacteristic.UNDODGEABLE);
    }
}
