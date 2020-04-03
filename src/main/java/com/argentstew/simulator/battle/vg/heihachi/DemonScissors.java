package com.argentstew.simulator.battle.vg.heihachi;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.heihachi
 * 8/24/2019
 *
 * @author Craig
 */
public class DemonScissors extends MeleeAttack {

    public DemonScissors() {
        super();
        this.name = "Demon Scissors";
        this.power = 70;
        this.variance = 7;
        this.speed = 2.5;
        this.subtypes = Collections.singletonList(AttackSubType.KICK);
        this.characteristics = Collections.emptyList();
    }
}
