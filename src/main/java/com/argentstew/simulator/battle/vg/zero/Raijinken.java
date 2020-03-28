package com.argentstew.simulator.battle.vg.zero;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.zero
 * 8/27/2019
 *
 * @author Craig
 */
public class Raijinken extends MeleeAttack {

    public Raijinken() {
        super();
        this.name = "Raijinken";
        this.power = 65;
        this.variance = 7;
        this.speed = 1;
        this.subtypes = Arrays.asList(AttackSubType.PUNCH, AttackSubType.THUNDER);
        this.characteristics = Collections.emptyList();
    }
}
