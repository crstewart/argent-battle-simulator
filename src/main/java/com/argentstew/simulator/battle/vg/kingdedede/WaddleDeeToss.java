package com.argentstew.simulator.battle.vg.kingdedede;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;
import com.argentstew.simulator.battle.fighter.Fighter;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.kingdedede
 * 8/24/2019
 *
 * @author Craig
 */
public class WaddleDeeToss extends RangedAttack {

    public WaddleDeeToss() {
        super();
        this.name = "Waddle Dee Toss";
        this.power = 55;
        this.variance = 3;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.SLAM);
        this.characteristics = Collections.emptyList();
    }

    @Override
    protected double getCritChance(Fighter defender) {
        double baseCritChance = super.getCritChance(defender);
        return baseCritChance * 1.5;
    }
}
