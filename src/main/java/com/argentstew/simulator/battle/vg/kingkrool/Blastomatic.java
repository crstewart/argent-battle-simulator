package com.argentstew.simulator.battle.vg.kingkrool;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedXStrike;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.kingkrool
 * 8/24/2019
 *
 * @author Craig
 */
public class Blastomatic extends RangedXStrike {

    public Blastomatic() {
        super();
        this.name = "Blast-o-matic";
        this.power = 280;
        this.variance = 18;
        this.speed = 5;
        this.subtypes = Collections.singletonList(AttackSubType.PLASMA);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNGUARDABLE, AttackCharacteristic.UNDODGEABLE);
    }
}
