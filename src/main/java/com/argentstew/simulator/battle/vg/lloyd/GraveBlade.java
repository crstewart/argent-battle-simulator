package com.argentstew.simulator.battle.vg.lloyd;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.lloyd
 * 8/27/2019
 *
 * @author Craig
 */
public class GraveBlade extends MeleeAttack {

    public GraveBlade() {
        super();
        this.name = "Grave Blade";
        this.power = 70;
        this.variance = 7;
        this.speed = 2.5;
        this.subtypes = Arrays.asList(AttackSubType.SLASH, AttackSubType.EARTH);
        this.characteristics = Collections.emptyList();
    }
}
