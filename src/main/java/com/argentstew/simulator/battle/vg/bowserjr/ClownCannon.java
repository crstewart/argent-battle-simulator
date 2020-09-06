package com.argentstew.simulator.battle.vg.bowserjr;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.bowserjr
 * 8/24/2019
 *
 * @author Craig
 */
public class ClownCannon extends RangedAttack {

    public ClownCannon() {
        super();
        this.name = "Clown Cannon";
        this.power = 70;
        this.variance = 7;
        this.speed = 2;
        this.subtypes = Collections.singletonList(AttackSubType.SMASH);
        this.characteristics = Collections.emptyList();
    }
}
