package com.argentstew.simulator.battle.vg.ness;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.ness
 * 8/27/2019
 *
 * @author Craig
 */
public class CaseyBat extends MeleeAttack {

    public CaseyBat() {
        super();
        this.name = "Casey Bat";
        this.power = 80;
        this.variance = 7;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.SMASH);
        this.characteristics = Collections.emptyList();
    }
}
