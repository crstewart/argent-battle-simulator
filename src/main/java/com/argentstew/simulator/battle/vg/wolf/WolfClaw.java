package com.argentstew.simulator.battle.vg.wolf;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.wolf
 * 8/24/2019
 *
 * @author Craig
 */
public class WolfClaw extends MeleeAttack {

    public WolfClaw() {
        super();
        this.name = "Wolf Claw";
        this.power = 60;
        this.variance = 6;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.CLAW);
        this.characteristics = Collections.emptyList();
    }
}
