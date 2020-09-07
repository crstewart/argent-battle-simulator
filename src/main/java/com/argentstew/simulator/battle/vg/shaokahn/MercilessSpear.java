package com.argentstew.simulator.battle.vg.shaokahn;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;
import com.argentstew.simulator.battle.action.attack.RangedAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.shaokahn
 * 8/27/2019
 *
 * @author Craig
 */
public class MercilessSpear extends RangedAttack {

    public MercilessSpear() {
        super();
        this.name = "Merciless Spear";
        this.power = 70;
        this.variance = 7;
        this.speed = 2;
        this.subtypes = Collections.singletonList(AttackSubType.PIERCE);
        this.characteristics = Collections.emptyList();
    }
}
