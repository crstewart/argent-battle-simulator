package com.argentstew.simulator.battle.vg.deathwing;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;
import com.argentstew.simulator.battle.action.attack.RangedAttack;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.deathwing
 * 8/24/2019
 *
 * @author Craig
 */
public class Incinerate extends MeleeAttack {

    public Incinerate() {
        super();
        this.name = "Incinerate";
        this.power = 70;
        this.variance = 7;
        this.speed = 1;
        this.subtypes = Arrays.asList(AttackSubType.WING, AttackSubType.FIRE);
        this.characteristics = Collections.emptyList();
    }
}
