package com.argentstew.simulator.battle.vg.pacman;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.pacman
 * 8/27/2019
 *
 * @author Craig
 */
public class Galaxian extends RangedAttack {

    public Galaxian() {
        super();
        this.name = "Galaxian";
        this.power = 70;
        this.variance = 7;
        this.speed = 2;
        this.subtypes = Collections.singletonList(AttackSubType.SLAM);
        this.characteristics = Collections.emptyList();
    }
}
