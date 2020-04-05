package com.argentstew.simulator.battle.vg.thrall;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.thrall
 * 8/27/2019
 *
 * @author Craig
 */
public class Doomhammer extends MeleeAttack {

    public Doomhammer() {
        super();
        this.name = "Doomhammer";
        this.power = 60;
        this.variance = 6;
        this.speed = 1.5;
        this.subtypes = Collections.singletonList(AttackSubType.SMASH);
        this.characteristics = Collections.emptyList();
    }
}
