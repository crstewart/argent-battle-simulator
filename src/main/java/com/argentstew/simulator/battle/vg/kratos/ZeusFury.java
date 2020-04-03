package com.argentstew.simulator.battle.vg.kratos;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MagicAttack;
import com.argentstew.simulator.battle.action.attack.RangedAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.kratos
 * 8/24/2019
 *
 * @author Craig
 */
public class ZeusFury extends MagicAttack {

    public ZeusFury() {
        super();
        this.name = "Zeus' Fury";
        this.power = 55;
        this.variance = 6;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.THUNDER);
        this.characteristics = Collections.emptyList();
    }
}
