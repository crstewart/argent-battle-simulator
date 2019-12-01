package com.argentstew.simulator.battle.vg.fox;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;
import com.argentstew.simulator.battle.fighter.Fighter;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.fox
 * 8/24/2019
 *
 * @author Craig
 */
public class Blaster extends RangedAttack {

    public Blaster() {
        super();
        this.name = "Blaster";
        this.power = 50;
        this.variance = 8;
        this.speed = 0.5;
        this.subtypes = Collections.singletonList(AttackSubType.PLASMA);
        this.characteristics = Collections.emptyList();
    }

    @Override
    public double getStunChance(Fighter defender, boolean isCrit) {
        return 0.0;
    }
}
