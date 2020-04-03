package com.argentstew.simulator.battle.vg.ratchet;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.ratchet
 * 8/27/2019
 *
 * @author Craig
 */
public class Omniwrench extends MeleeAttack {

    public Omniwrench() {
        super();
        this.name = "OmniWrench";
        this.power = 50;
        this.variance = 4;
        this.speed = 0.5;
        this.subtypes = Collections.singletonList(AttackSubType.SMASH);
        this.characteristics = Collections.emptyList();
    }
}
