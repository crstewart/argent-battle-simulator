package com.argentstew.simulator.battle.vg.luigi;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;
import com.argentstew.simulator.battle.fighter.Fighter;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.mario
 * 8/24/2019
 *
 * @author Craig
 */
public class SuperPunch extends MeleeAttack {

    public SuperPunch() {
        super();
        this.name = "Super Punch";
        this.description = "Has double critical hit chance";
        this.power = 60;
        this.variance = 4;
        this.speed = 0.5;
        this.subtypes = Collections.singletonList(AttackSubType.PUNCH);
        this.characteristics = Collections.emptyList();
    }

    @Override
    protected double getCritChance(Fighter defender) {
        double baseCritChance = super.getCritChance(defender);
        return baseCritChance * 2;
    }
}
