package com.argentstew.simulator.battle.vg.slycooper;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.sly
 * 8/27/2019
 *
 * @author Craig
 */
public class ShadowPower extends MeleeAttack {

    public ShadowPower() {
        super();
        this.name = "Shadow Power";
        this.power = 40;
        this.variance = 4;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.SMASH);
        this.characteristics = Collections.singletonList(AttackCharacteristic.STEALTH);
    }
}
