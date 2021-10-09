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
public class GreatSpear extends MeleeAttack {

    public GreatSpear() {
        super();
        this.name = "Great Spear";
        this.power = 90;
        this.variance = 5;
        this.speed = 2.5;
        this.subtypes = Collections.singletonList(AttackSubType.PIERCE);
        this.characteristics = Collections.emptyList();
    }
}
