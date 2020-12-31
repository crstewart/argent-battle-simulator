package com.argentstew.simulator.battle.vg.terry;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.terry
 * 8/24/2019
 *
 * @author Craig
 */
public class PowerDunk extends MeleeAttack {

    public PowerDunk() {
        super();
        this.name = "Power Dunk";
        this.power = 65;
        this.variance = 6;
        this.speed = 2;
        this.subtypes = Arrays.asList(AttackSubType.PUNCH, AttackSubType.CHI);
        this.characteristics = Collections.emptyList();
    }
}
