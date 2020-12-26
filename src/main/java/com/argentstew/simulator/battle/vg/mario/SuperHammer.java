package com.argentstew.simulator.battle.vg.mario;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.mario
 * 8/24/2019
 *
 * @author Craig
 */
public class SuperHammer extends MeleeAttack {

    public SuperHammer() {
        super();
        this.name = "Super Hammer";
        this.power = 90;
        this.variance = 9;
        this.speed = 3;
        this.subtypes = Collections.singletonList(AttackSubType.SMASH);
        this.characteristics = Collections.emptyList();
    }
}
