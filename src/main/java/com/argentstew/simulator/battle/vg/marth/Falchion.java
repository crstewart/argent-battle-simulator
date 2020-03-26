package com.argentstew.simulator.battle.vg.marth;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.marth
 * 8/27/2019
 *
 * @author Craig
 */
public class Falchion extends MeleeAttack {

    public Falchion() {
        super();
        this.name = "Falchion";
        this.power = 50;
        this.variance = 4;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.SLASH);
        this.characteristics = Collections.emptyList();
    }
}
