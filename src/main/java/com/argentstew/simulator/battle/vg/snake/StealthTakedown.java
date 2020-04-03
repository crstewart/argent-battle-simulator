package com.argentstew.simulator.battle.vg.snake;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.snake
 * 8/27/2019
 *
 * @author Craig
 */
public class StealthTakedown extends MeleeAttack {

    public StealthTakedown() {
        super();
        this.name = "Stealth Takedown";
        this.power = 40;
        this.variance = 4;
        this.speed = 0.5;
        this.subtypes = Collections.singletonList(AttackSubType.GRAPPLE);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNGUARDABLE, AttackCharacteristic.UNDODGEABLE);
    }
}
