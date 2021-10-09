package com.argentstew.simulator.battle.vg.tyrael;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeXStrike;

import java.util.Arrays;

/**
 * com.argentstew.simulator.battle.vg.tyrael
 * 8/26/2019
 *
 * @author Craig
 */
public class ArchangelsJudgment extends MeleeXStrike {

    public ArchangelsJudgment() {
        super();
        this.name = "Archangel's Judgment";
        this.power = 280;
        this.variance = 12;
        this.speed = 1;
        this.subtypes = Arrays.asList(AttackSubType.LIGHT, AttackSubType.SLASH);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNGUARDABLE, AttackCharacteristic.UNDODGEABLE);
    }
}
