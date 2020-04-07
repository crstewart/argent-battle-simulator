package com.argentstew.simulator.battle.vg.dovahkiin;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedXStrike;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.dovahkiin
 * 8/24/2019
 *
 * @author Craig
 */
public class CallDragon extends RangedXStrike {

    public CallDragon() {
        super();
        this.name = "Call Dragon (Od Ah Viing)";
        this.power = 250;
        this.variance = 15;
        this.speed = 2;
        this.subtypes = Collections.singletonList(AttackSubType.FIRE);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNGUARDABLE, AttackCharacteristic.UNDODGEABLE);
    }
}
