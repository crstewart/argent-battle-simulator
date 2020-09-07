package com.argentstew.simulator.battle.vg.samfisher;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.samfisher
 * 8/24/2019
 *
 * @author Craig
 */
public class StealthTakedown extends MeleeAttack {

    public StealthTakedown() {
        super();
        this.name = "Stealth Takedown";
        this.power = 40;
        this.variance = 4;
        this.speed = 3;
        this.subtypes = Collections.singletonList(AttackSubType.GRAPPLE);
        this.characteristics = Collections.singletonList(AttackCharacteristic.STEALTH);
    }
}
