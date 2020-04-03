package com.argentstew.simulator.battle.vg.ratchet;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.ratchet
 * 8/24/2019
 *
 * @author Craig
 */
public class FusionGrenade extends RangedAttack {

    public FusionGrenade() {
        super();
        this.name = "Fusion Grenade";
        this.power = 65;
        this.variance = 6;
        this.speed = 2;
        this.subtypes = Collections.singletonList(AttackSubType.EXPLOSIVE);
        this.characteristics = Collections.emptyList();
    }
}
