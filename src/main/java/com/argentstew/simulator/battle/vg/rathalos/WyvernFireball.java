package com.argentstew.simulator.battle.vg.rathalos;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.rathalos
 * 8/24/2019
 *
 * @author Craig
 */
public class WyvernFireball extends RangedAttack {

    public WyvernFireball() {
        super();
        this.name = "Wyvern Fireball";
        this.power = 75;
        this.variance = 7;
        this.speed = 1.5;
        this.subtypes = Collections.singletonList(AttackSubType.FIRE);
        this.characteristics = Collections.emptyList();
    }
}
