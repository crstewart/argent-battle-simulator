package com.argentstew.simulator.battle.vg.morrigan;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedXStrike;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.morrigan
 * 8/24/2019
 *
 * @author Craig
 */
public class DarknessIllusion extends RangedXStrike {

    public DarknessIllusion() {
        super();
        this.name = "Darkness Illusion";
        this.power = 240;
        this.variance = 14;
        this.speed = 2;
        this.subtypes = Collections.singletonList(AttackSubType.DARK);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNGUARDABLE, AttackCharacteristic.UNDODGEABLE);
    }
}
