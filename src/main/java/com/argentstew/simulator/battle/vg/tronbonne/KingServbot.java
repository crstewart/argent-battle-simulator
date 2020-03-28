package com.argentstew.simulator.battle.vg.tronbonne;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeXStrike;
import com.argentstew.simulator.battle.action.attack.RangedXStrike;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.yoshi
 * 8/26/2019
 *
 * @author Craig
 */
public class KingServbot extends MeleeXStrike {

    public KingServbot() {
        super();
        this.name = "King Servbot";
        this.power = 250;
        this.variance = 15;
        this.speed = 1.5;
        this.subtypes = Arrays.asList(AttackSubType.SMASH, AttackSubType.ASSIST);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNGUARDABLE, AttackCharacteristic.UNDODGEABLE);
    }
}
