package com.argentstew.simulator.battle.vg.wander;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;
import com.argentstew.simulator.battle.fighter.Fighter;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.wander
 * 8/27/2019
 *
 * @author Craig
 */
public class AncientBow extends RangedAttack {

    public AncientBow() {
        super();
        this.name = "Ancient Bow";
        this.description = "Has double the normal stun chance";
        this.power = 40;
        this.variance = 4;
        this.speed = 2;
        this.subtypes = Collections.singletonList(AttackSubType.PIERCE);
        this.characteristics = Collections.emptyList();
    }

    @Override
    public double getStunChance(Fighter defender, boolean isCrit) {
        return super.getStunChance(defender, isCrit) * 2;
    }
}
