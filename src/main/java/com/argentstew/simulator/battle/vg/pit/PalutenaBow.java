package com.argentstew.simulator.battle.vg.pit;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.pit
 * 8/27/2019
 *
 * @author Craig
 */
public class PalutenaBow extends RangedAttack {

    public PalutenaBow() {
        super();
        this.name = "Palutena Bow";
        this.power = 50;
        this.variance = 4;
        this.speed = 3;
        this.subtypes = Arrays.asList(AttackSubType.PIERCE, AttackSubType.LIGHT);
        this.characteristics = Collections.emptyList();
    }
}
