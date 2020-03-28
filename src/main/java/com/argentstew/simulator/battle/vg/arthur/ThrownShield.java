package com.argentstew.simulator.battle.vg.arthur;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.arthur
 * 8/24/2019
 *
 * @author Craig
 */
public class ThrownShield extends RangedAttack {

    public ThrownShield() {
        super();
        this.name = "Thrown Shield";
        this.power = 30;
        this.variance = 4;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.SMASH);
        this.characteristics = Collections.emptyList();
    }
}
