package com.argentstew.simulator.battle.vg.wolf;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedXStrike;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.wolf
 * 8/24/2019
 *
 * @author Craig
 */
public class WolfenAssault extends RangedXStrike {

    public WolfenAssault() {
        super();
        this.name = "Wolfen Assault";
        this.power = 280;
        this.variance = 10;
        this.speed = 4;
        this.subtypes = Collections.singletonList(AttackSubType.PLASMA);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNGUARDABLE, AttackCharacteristic.UNDODGEABLE);
    }
}
