package com.argentstew.simulator.battle.vg.pacman;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;
import com.argentstew.simulator.battle.action.attack.RangedAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.pacman
 * 8/27/2019
 *
 * @author Craig
 */
public class BonusFruit extends RangedAttack {

    public BonusFruit() {
        super();
        this.name = "Bonus Fruit";
        this.power = 45;
        this.variance = 15;
        this.speed = 1.5;
        this.subtypes = Collections.singletonList(AttackSubType.NATURE);
        this.characteristics = Collections.emptyList();
    }
}
