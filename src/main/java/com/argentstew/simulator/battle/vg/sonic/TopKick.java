package com.argentstew.simulator.battle.vg.sonic;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.sonic
 * 8/27/2019
 *
 * @author Craig
 */
public class TopKick extends MeleeAttack {

    public TopKick() {
        super();
        this.name = "Top Kick";
        this.power = 40;
        this.variance = 4;
        this.speed = 0.5;
        this.subtypes = Collections.singletonList(AttackSubType.KICK);
        this.characteristics = Collections.emptyList();
    }

    @Override
    public double calculateSpeed() {
        return this.speed;
    }
}
