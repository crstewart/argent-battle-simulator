package com.argentstew.simulator.battle.vg.masterchief;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedXStrike;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.masterchief
 * 8/24/2019
 *
 * @author Craig
 */
public class SpartanLaser extends RangedXStrike {

    public SpartanLaser() {
        super();
        this.name = "Spartan Laser";
        this.power = 240;
        this.variance = 14;
        this.speed = 6;
        this.subtypes = Collections.singletonList(AttackSubType.PLASMA);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNGUARDABLE, AttackCharacteristic.UNDODGEABLE);
    }
}
