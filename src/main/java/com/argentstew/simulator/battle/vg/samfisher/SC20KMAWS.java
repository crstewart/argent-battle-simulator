package com.argentstew.simulator.battle.vg.samfisher;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeXStrike;
import com.argentstew.simulator.battle.action.attack.RangedXStrike;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.samfisher
 * 8/24/2019
 *
 * @author Craig
 */
public class SC20KMAWS extends RangedXStrike {

    public SC20KMAWS() {
        super();
        this.name = "SC-20K M.A.W.S.";
        this.power = 200;
        this.variance = 25;
        this.speed = 3;
        this.subtypes = Collections.singletonList(AttackSubType.RIFLE);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNGUARDABLE, AttackCharacteristic.UNDODGEABLE);
    }
}
