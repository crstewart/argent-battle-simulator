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
public class PowerPellet extends RangedAttack {

    public PowerPellet() {
        super();
        this.name = "Power Pellet";
        this.power = 80;
        this.variance = 8;
        this.speed = 2.5;
        this.subtypes = Collections.emptyList();
        this.characteristics = Collections.emptyList();
    }
}
