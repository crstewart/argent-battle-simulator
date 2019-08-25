package com.argentstew.simulator.battle.vg.luigi;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.mario
 * 8/24/2019
 *
 * @author Craig
 */
public class GreenFireball extends RangedAttack {

    public GreenFireball() {
        super();
        this.name = "Green Fireball";
        this.power = 20;
        this.variance = 2;
        this.speed = 0.5;
        this.subtypes = Collections.singletonList(AttackSubType.FIRE);
        this.characteristics = Collections.emptyList();
    }
}
