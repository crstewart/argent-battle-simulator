package com.argentstew.simulator.battle.vg.palutena;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedXStrike;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.palutena
 * 9/7/2019
 *
 * @author Craig
 */
public class MegaLaser extends RangedXStrike {

    public MegaLaser() {
        super();
        this.name = "Mega Laser";
        this.power = 280;
        this.variance = 25;
        this.speed = 3;
        this.subtypes = Collections.singletonList(AttackSubType.PLASMA);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNGUARDABLE, AttackCharacteristic.UNDODGEABLE);
    }
}
