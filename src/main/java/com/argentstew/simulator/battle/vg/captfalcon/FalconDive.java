package com.argentstew.simulator.battle.vg.captfalcon;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.captfalcon
 * 8/27/2019
 *
 * @author Craig
 */
public class FalconDive extends MeleeAttack {

    public FalconDive() {
        super();
        this.name = "Falcon Dive";
        this.power = 35;
        this.variance = 3;
        this.speed = 1.5;
        this.subtypes = Arrays.asList(AttackSubType.GRAPPLE, AttackSubType.FIRE);
        this.characteristics = Collections.singletonList(AttackCharacteristic.UNGUARDABLE);
    }
}
