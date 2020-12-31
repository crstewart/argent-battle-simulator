package com.argentstew.simulator.battle.vg.tails;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.tails
 * 8/26/2019
 *
 * @author Craig
 */
public class BombDrop extends RangedAttack {

    public BombDrop() {
        super();
        this.name = "Bomb Drop";
        this.power = 80;
        this.variance = 8;
        this.speed = 2;
        this.subtypes = Collections.singletonList(AttackSubType.EXPLOSIVE);
        this.characteristics = Collections.emptyList();
    }
}
