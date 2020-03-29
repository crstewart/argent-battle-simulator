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
public class Explosion extends MeleeAttack {

    public Explosion() {
        super();
        this.name = "Explosion";
        this.power = 45;
        this.variance = 4;
        this.speed = 1.5;
        this.subtypes = Collections.singletonList(AttackSubType.EXPLOSIVE);
        this.characteristics = Collections.singletonList(AttackCharacteristic.UNDODGEABLE);
    }
}
