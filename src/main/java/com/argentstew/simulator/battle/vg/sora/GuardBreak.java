package com.argentstew.simulator.battle.vg.sora;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.sora
 * 8/27/2019
 *
 * @author Craig
 */
public class GuardBreak extends MeleeAttack {

    public GuardBreak() {
        super();
        this.name = "Guard Break";
        this.power = 40;
        this.variance = 4;
        this.speed = 1.5;
        this.subtypes = Collections.singletonList(AttackSubType.SLASH);
        this.characteristics = Collections.singletonList(AttackCharacteristic.UNGUARDABLE);
    }
}
