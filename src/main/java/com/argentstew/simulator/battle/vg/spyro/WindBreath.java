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
public class WindBreath extends RangedAttack {

    public WindBreath() {
        super();
        this.name = "Wind Breath";
        this.power = 65;
        this.variance = 4;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.AIR);
        this.characteristics = Collections.emptyList();
    }
}
