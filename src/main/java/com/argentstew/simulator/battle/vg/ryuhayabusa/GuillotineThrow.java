package com.argentstew.simulator.battle.vg.ryuhayabusa;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.ryuhayabusa
 * 8/27/2019
 *
 * @author Craig
 */
public class GuillotineThrow extends MeleeAttack {

    public GuillotineThrow() {
        super();
        this.name = "Guillotine Throw";
        this.power = 40;
        this.variance = 5;
        this.speed = 0.5;
        this.subtypes = Collections.singletonList(AttackSubType.GRAPPLE);
        this.characteristics = Collections.singletonList(AttackCharacteristic.UNGUARDABLE);
    }
}
