package com.argentstew.simulator.battle.vg.ezio;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;
import com.argentstew.simulator.battle.action.attack.RangedAttack;
import com.argentstew.simulator.battle.fighter.Fighter;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.ezio
 * 8/27/2019
 *
 * @author Craig
 */
public class Crossbow extends RangedAttack {

    public Crossbow() {
        super();
        this.name = "Crossbow";
        this.power = 50;
        this.variance = 5;
        this.speed = 1.5;
        this.subtypes = Collections.singletonList(AttackSubType.PIERCE);
        this.characteristics = Collections.emptyList();
    }

    @Override
    public double getCritChance(Fighter defender) {
        return super.getCritChance(defender) * 1.5;
    }
}
