package com.argentstew.simulator.battle.vg.mallow;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.mallow
 * 8/27/2019
 *
 * @author Craig
 */
public class Cymbals extends RangedAttack {

    public Cymbals() {
        super();
        this.name = "Cymbals";
        this.power = 40;
        this.variance = 6;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.SOUND);
        this.characteristics = Collections.emptyList();
    }
}
