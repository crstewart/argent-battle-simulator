package com.argentstew.simulator.battle.vg.waluigi;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.waluigi
 * 8/27/2019
 *
 * @author Craig
 */
public class Stomp extends MeleeAttack {

    public Stomp() {
        super();
        this.name = "Stomp";
        this.power = 55;
        this.variance = 5;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.KICK);
        this.characteristics = Collections.emptyList();
    }
}
