package com.argentstew.simulator.battle.vg.decidueye;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;
import com.argentstew.simulator.battle.fighter.Fighter;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.decidueye
 * 9/7/2019
 *
 * @author Craig
 */
public class LeafBlade extends MeleeAttack {

    public LeafBlade() {
        super();
        this.name = "Leaf Blade";
        this.description = "Has 33% critical hit rate";
        this.power = 90;
        this.variance = 8;
        this.speed = 2.5;
        this.subtypes = Arrays.asList(AttackSubType.NATURE, AttackSubType.SLASH);
        this.characteristics = Collections.emptyList();
    }

    @Override
    public double getCritChance(Fighter defender) {
        return 1 / 3.0;
    }
}
