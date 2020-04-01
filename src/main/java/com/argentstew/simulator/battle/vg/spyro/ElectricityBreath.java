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
public class ElectricityBreath extends RangedAttack {

    public ElectricityBreath() {
        super();
        this.name = "Electricity Breath";
        this.power = 55;
        this.variance = 7;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.THUNDER);
        this.characteristics = Collections.emptyList();
    }
}
