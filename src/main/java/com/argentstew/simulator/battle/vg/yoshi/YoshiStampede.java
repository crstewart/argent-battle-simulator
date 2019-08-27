package com.argentstew.simulator.battle.vg.yoshi;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;
import com.argentstew.simulator.battle.action.attack.MeleeXStrike;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.yoshi
 * 8/26/2019
 *
 * @author Craig
 */
public class YoshiStampede extends MeleeXStrike {

    public YoshiStampede() {
        super();
        this.name = "Yoshi Stampede";
        this.power = 240;
        this.variance = 14;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.ASSIST);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNGUARDABLE, AttackCharacteristic.UNDODGEABLE);
    }
}
