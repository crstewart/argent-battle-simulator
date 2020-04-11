package com.argentstew.simulator.battle.vg.draven;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;
import com.argentstew.simulator.battle.action.attack.RangedAttack;
import com.argentstew.simulator.battle.fighter.Fighter;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.draven
 * 8/24/2019
 *
 * @author Craig
 */
public class ThrowingAxe extends RangedAttack {

    public ThrowingAxe() {
        super();
        this.name = "Throwing Axe";
        this.power = 50;
        this.variance = 4;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.HACK);
        this.characteristics = Collections.emptyList();
    }

    @Override
    public double getCritMultiplier(Fighter defender) {
        return 2.5;
    }
}
