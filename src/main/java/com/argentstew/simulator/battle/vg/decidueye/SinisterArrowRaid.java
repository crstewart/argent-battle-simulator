package com.argentstew.simulator.battle.vg.decidueye;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedXStrike;

import java.util.Arrays;

/**
 * com.argentstew.simulator.battle.vg.decidueye
 * 9/7/2019
 *
 * @author Craig
 */
public class SinisterArrowRaid extends RangedXStrike {

    public SinisterArrowRaid() {
        super();
        this.name = "Sinister Arrow Raid";
        this.power = 200;
        this.variance = 30;
        this.speed = 6;
        this.subtypes = Arrays.asList(AttackSubType.DARK, AttackSubType.PIERCE);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNGUARDABLE, AttackCharacteristic.UNDODGEABLE);
    }
}
