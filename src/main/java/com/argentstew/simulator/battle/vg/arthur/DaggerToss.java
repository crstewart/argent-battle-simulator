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
public class DaggerToss extends RangedAttack {

    public DaggerToss() {
        super();
        this.name = "Dagger Toss";
        this.power = 60;
        this.variance = 6;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.SLASH);
        this.characteristics = Collections.emptyList();
    }
}
