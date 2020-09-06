package com.argentstew.simulator.battle.vg.sweettooth;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.sweettooth
 * 8/24/2019
 *
 * @author Craig
 */
public class JawBreaker extends MeleeAttack {

    public JawBreaker() {
        super();
        this.name = "Jaw Breaker";
        this.power = 50;
        this.variance = 8;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.PUNCH);
        this.characteristics = Collections.emptyList();
    }
}
