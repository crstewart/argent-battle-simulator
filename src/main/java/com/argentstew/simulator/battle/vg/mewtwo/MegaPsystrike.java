package com.argentstew.simulator.battle.vg.mewtwo;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedXStrike;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.mewtwo
 * 9/15/2019
 *
 * @author Craig
 */
public class MegaPsystrike extends RangedXStrike {

    public MegaPsystrike() {
        super();
        this.name = "Mega Psystrike";
        this.power = 220;
        this.variance = 12;
        this.speed = 6;
        this.subtypes = Collections.singletonList(AttackSubType.MYSTIC);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNGUARDABLE, AttackCharacteristic.UNDODGEABLE);
    }
}
