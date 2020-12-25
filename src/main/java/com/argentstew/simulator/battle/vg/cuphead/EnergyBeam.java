package com.argentstew.simulator.battle.vg.cuphead;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeXStrike;
import com.argentstew.simulator.battle.action.attack.RangedXStrike;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.cuphead
 * 8/24/2019
 *
 * @author Craig
 */
public class EnergyBeam extends RangedXStrike {

    public EnergyBeam() {
        super();
        this.name = "Energy Beam";
        this.power = 260;
        this.variance = 15;
        this.speed = 4;
        this.subtypes = Collections.emptyList();
        this.characteristics = Arrays.asList(AttackCharacteristic.UNGUARDABLE, AttackCharacteristic.UNDODGEABLE);
    }
}
