package com.argentstew.simulator.battle.vg.steve;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;
import com.argentstew.simulator.battle.fighter.Fighter;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.steve
 * 8/27/2019
 *
 * @author Craig
 */
public class BowCritical extends RangedAttack {

    public BowCritical() {
        super();
        this.name = "Bow (Critical)";
        this.power = 60;
        this.variance = 6;
        this.speed = 4;
        this.subtypes = Collections.singletonList(AttackSubType.PIERCE);
        this.characteristics = Collections.emptyList();
    }

    @Override
    protected double getCritChance(Fighter defender) {
        return 1;
    }
}
