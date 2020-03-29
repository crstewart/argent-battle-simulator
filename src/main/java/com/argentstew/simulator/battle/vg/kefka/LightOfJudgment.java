package com.argentstew.simulator.battle.vg.kefka;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MagicXStrike;
import com.argentstew.simulator.battle.action.attack.RangedXStrike;

import java.util.Arrays;

/**
 * com.argentstew.simulator.battle.vg.kefka
 * 8/24/2019
 *
 * @author Craig
 */
public class LightOfJudgment extends MagicXStrike {

    public LightOfJudgment() {
        super();
        this.name = "Light of Judgment";
        this.power = 180;
        this.variance = 30;
        this.speed = 5;
        this.subtypes = Arrays.asList(AttackSubType.LIGHT, AttackSubType.DARK);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNGUARDABLE, AttackCharacteristic.UNDODGEABLE);
    }
}
