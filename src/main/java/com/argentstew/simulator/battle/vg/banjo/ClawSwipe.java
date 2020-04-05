package com.argentstew.simulator.battle.vg.banjo;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.banjo
 * 9/8/2019
 *
 * @author Craig
 */
public class ClawSwipe extends MeleeAttack {

    public ClawSwipe() {
        super();
        this.name = "Claw Swipe";
        this.power = 50;
        this.variance = 4;
        this.speed = 0.5;
        this.subtypes = Collections.singletonList(AttackSubType.CLAW);
        this.characteristics = Collections.emptyList();
    }
}
