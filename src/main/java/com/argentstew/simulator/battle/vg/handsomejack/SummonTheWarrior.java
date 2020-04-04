package com.argentstew.simulator.battle.vg.handsomejack;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedXStrike;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.handsomejack
 * 8/24/2019
 *
 * @author Craig
 */
public class SummonTheWarrior extends RangedXStrike {

    public SummonTheWarrior() {
        super();
        this.name = "Summon the Warrior";
        this.power = 240;
        this.variance = 14;
        this.speed = 3;
        this.subtypes = Collections.singletonList(AttackSubType.ASSIST);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNGUARDABLE, AttackCharacteristic.UNDODGEABLE);
    }
}
