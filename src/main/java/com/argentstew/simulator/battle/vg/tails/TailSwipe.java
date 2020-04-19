package com.argentstew.simulator.battle.vg.tails;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.tails
 * 8/27/2019
 *
 * @author Craig
 */
public class TailSwipe extends MeleeAttack {

    public TailSwipe() {
        super();
        this.name = "Tail Swipe";
        this.description = "No additional startup time";
        this.power = 40;
        this.variance = 5;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.TAIL);
        this.characteristics = Collections.emptyList();
    }

    @Override
    public double calculateSpeed() {
        return this.speed;
    }
}
