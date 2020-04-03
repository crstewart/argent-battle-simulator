package com.argentstew.simulator.battle.vg.kratos;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.kratos
 * 8/27/2019
 *
 * @author Craig
 */
public class NemeanCestus extends MeleeAttack {

    public NemeanCestus() {
        super();
        this.name = "Nemean Cestus";
        this.power = 70;
        this.variance = 6;
        this.speed = 2;
        this.subtypes = Collections.singletonList(AttackSubType.SMASH);
        this.characteristics = Collections.emptyList();
    }
}
