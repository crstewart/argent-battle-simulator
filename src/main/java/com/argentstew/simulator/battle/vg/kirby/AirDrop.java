package com.argentstew.simulator.battle.vg.kirby;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.kirby
 * 8/24/2019
 *
 * @author Craig
 */
public class AirDrop extends MeleeAttack {

    public AirDrop() {
        super();
        this.name = "Air Drop";
        this.power = 80;
        this.variance = 7;
        this.speed = 0.5;
        this.subtypes = Collections.singletonList(AttackSubType.GRAPPLE);
        this.characteristics = Collections.singletonList(AttackCharacteristic.UNGUARDABLE);
    }
}
