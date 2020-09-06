package com.argentstew.simulator.battle.vg.kingkrool;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.kingkrool
 * 8/24/2019
 *
 * @author Craig
 */
public class Crownarang extends RangedAttack {

    public Crownarang() {
        super();
        this.name = "Crown-a-rang";
        this.power = 55;
        this.variance = 5;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.SMASH);
        this.characteristics = Collections.emptyList();
    }
}
