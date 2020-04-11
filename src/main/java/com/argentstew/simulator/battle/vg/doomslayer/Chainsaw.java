package com.argentstew.simulator.battle.vg.doomslayer;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.doomslayer
 * 8/24/2019
 *
 * @author Craig
 */
public class Chainsaw extends MeleeAttack {

    public Chainsaw() {
        super();
        this.name = "Chainsaw";
        this.power = 55;
        this.variance = 7;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.HACK);
        this.characteristics = Collections.emptyList();
    }
}
