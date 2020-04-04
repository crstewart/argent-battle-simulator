package com.argentstew.simulator.battle.vg.kosmos;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.kosmos
 * 8/24/2019
 *
 * @author Craig
 */
public class RCannon extends RangedAttack {

    public RCannon() {
        super();
        this.name = "R-Cannon";
        this.power = 90;
        this.variance = 9;
        this.speed = 1.5;
        this.subtypes = Collections.singletonList(AttackSubType.PLASMA);
        this.characteristics = Collections.emptyList();
    }
}
