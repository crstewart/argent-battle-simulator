package com.argentstew.simulator.battle.vg.wario;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;
import com.argentstew.simulator.battle.action.attack.MeleeXStrike;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.wario
 * 8/27/2019
 *
 * @author Craig
 */
public class WarioWaft extends MeleeXStrike {

    public WarioWaft() {
        super();
        this.name = "Wario Waft";
        this.power = 250;
        this.variance = 15;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.TOXIC);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNGUARDABLE, AttackCharacteristic.UNDODGEABLE);
    }
}
