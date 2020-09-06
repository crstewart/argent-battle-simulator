package com.argentstew.simulator.battle.vg.bowserjr;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.bowserjr
 * 8/24/2019
 *
 * @author Craig
 */
public class HammerWhack extends MeleeAttack {

    public HammerWhack() {
        super();
        this.name = "Hammer Whack";
        this.power = 50;
        this.variance = 5;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.SMASH);
        this.characteristics = Collections.emptyList();
    }
}
