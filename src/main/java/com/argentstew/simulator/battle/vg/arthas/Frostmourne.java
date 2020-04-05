package com.argentstew.simulator.battle.vg.arthas;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.arthas
 * 8/27/2019
 *
 * @author Craig
 */
public class Frostmourne extends MeleeAttack {

    public Frostmourne() {
        super();
        this.name = "Frostmourne";
        this.power = 65;
        this.variance = 6;
        this.speed = 1.5;
        this.subtypes = Arrays.asList(AttackSubType.SLASH, AttackSubType.DARK);
        this.characteristics = Collections.emptyList();
    }
}
