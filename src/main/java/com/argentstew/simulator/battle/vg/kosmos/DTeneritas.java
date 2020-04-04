package com.argentstew.simulator.battle.vg.kosmos;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MagicXStrike;
import com.argentstew.simulator.battle.action.attack.RangedXStrike;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.kosmos
 * 8/24/2019
 *
 * @author Craig
 */
public class DTeneritas extends RangedXStrike {

    public DTeneritas() {
        super();
        this.name = "D-Teneritas";
        this.power = 240;
        this.variance = 17;
        this.speed = 5;
        this.subtypes = Collections.singletonList(AttackSubType.PLASMA);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNDODGEABLE, AttackCharacteristic.UNGUARDABLE);
    }
}
