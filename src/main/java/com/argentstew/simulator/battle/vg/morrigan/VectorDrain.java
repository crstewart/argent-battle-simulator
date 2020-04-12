package com.argentstew.simulator.battle.vg.morrigan;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.morrigan
 * 8/27/2019
 *
 * @author Craig
 */
public class VectorDrain extends MeleeAttack {

    public VectorDrain() {
        super();
        this.name = "Vector Drain";
        this.power = 50;
        this.variance = 4;
        this.speed = 0.5;
        this.subtypes = Collections.singletonList(AttackSubType.GRAPPLE);
        this.characteristics = Collections.singletonList(AttackCharacteristic.UNGUARDABLE);
    }
}
