package com.argentstew.simulator.battle.vg.simon;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;
import com.argentstew.simulator.battle.action.attack.RangedAttack;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.simon
 * 8/27/2019
 *
 * @author Craig
 */
public class Cross extends RangedAttack {

    public Cross() {
        super();
        this.name = "Cross";
        this.power = 55;
        this.variance = 5;
        this.speed = 1;
        this.subtypes = Arrays.asList(AttackSubType.SMASH, AttackSubType.LIGHT);
        this.characteristics = Collections.emptyList();
    }
}
