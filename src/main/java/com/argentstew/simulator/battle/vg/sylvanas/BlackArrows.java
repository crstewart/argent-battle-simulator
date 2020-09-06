package com.argentstew.simulator.battle.vg.sylvanas;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;
import com.argentstew.simulator.battle.fighter.Fighter;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.sylvanas
 * 8/24/2019
 *
 * @author Craig
 */
public class BlackArrows extends RangedAttack {

    public BlackArrows() {
        super();
        this.name = "Black Arrows";
        this.description = "Has 50% bonus stun chance";
        this.power = 45;
        this.variance = 4;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.PIERCE);
        this.characteristics = Collections.emptyList();
    }

    @Override
    protected double getStunChance(Fighter defender, boolean isCrit) {
        return super.getStunChance(defender, isCrit) * 1.5;
    }
}
