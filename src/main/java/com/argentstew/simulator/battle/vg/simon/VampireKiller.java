package com.argentstew.simulator.battle.vg.simon;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.simon
 * 8/27/2019
 *
 * @author Craig
 */
public class VampireKiller extends MeleeAttack {

    public VampireKiller() {
        super();
        this.name = "Vampire Killer";
        this.power = 55;
        this.variance = 5;
        this.speed = 0.5;
        this.subtypes = Arrays.asList(AttackSubType.PIERCE, AttackSubType.LIGHT);
        this.characteristics = Collections.emptyList();
    }
}
