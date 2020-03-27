package com.argentstew.simulator.battle.vg.pit;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.pit
 * 8/27/2019
 *
 * @author Craig
 */
public class OreClub extends MeleeAttack {

    public OreClub() {
        super();
        this.name = "Ore Club";
        this.power = 75;
        this.variance = 5;
        this.speed = 1.5;
        this.subtypes = Arrays.asList(AttackSubType.SMASH, AttackSubType.EARTH);
        this.characteristics = Collections.emptyList();
    }
}
