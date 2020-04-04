package com.argentstew.simulator.battle.vg.kosmos;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.kosmos
 * 8/24/2019
 *
 * @author Craig
 */
public class RBlade extends MeleeAttack {

    public RBlade() {
        super();
        this.name = "R-Blade";
        this.power = 75;
        this.variance = 7;
        this.speed = 0.5;
        this.subtypes = Collections.singletonList(AttackSubType.SLASH);
        this.characteristics = Collections.emptyList();
    }
}
