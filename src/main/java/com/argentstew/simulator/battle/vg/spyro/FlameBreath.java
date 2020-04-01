package com.argentstew.simulator.battle.vg.spyro;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.spyro
 * 8/27/2019
 *
 * @author Craig
 */
public class FlameBreath extends RangedAttack {

    public FlameBreath() {
        super();
        this.name = "Flame Breath";
        this.power = 60;
        this.variance = 5;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.FIRE);
        this.characteristics = Collections.emptyList();
    }
}
