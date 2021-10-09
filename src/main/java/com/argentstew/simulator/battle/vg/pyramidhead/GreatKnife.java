package com.argentstew.simulator.battle.vg.pyramidhead;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.pyramidhead
 * 8/27/2019
 *
 * @author Craig
 */
public class GreatKnife extends MeleeAttack {

    public GreatKnife() {
        super();
        this.name = "Great Knife";
        this.power = 75;
        this.variance = 5;
        this.speed = 2;
        this.subtypes = Collections.singletonList(AttackSubType.HACK);
        this.characteristics = Collections.emptyList();
    }
}
