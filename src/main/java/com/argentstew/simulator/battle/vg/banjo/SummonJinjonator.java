package com.argentstew.simulator.battle.vg.banjo;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedXStrike;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.banjo
 * 9/7/2019
 *
 * @author Craig
 */
public class SummonJinjonator extends RangedXStrike {

    public SummonJinjonator() {
        super();
        this.name = "Summon Jinjonator";
        this.power = 250;
        this.variance = 15;
        this.speed = 3;
        this.subtypes = Arrays.asList(AttackSubType.SLAM, AttackSubType.ASSIST);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNGUARDABLE, AttackCharacteristic.UNDODGEABLE);
    }
}
