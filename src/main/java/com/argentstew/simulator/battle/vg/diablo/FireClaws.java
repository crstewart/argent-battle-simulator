package com.argentstew.simulator.battle.vg.diablo;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.diablo
 * 8/27/2019
 *
 * @author Craig
 */
public class FireClaws extends MeleeAttack {

    public FireClaws() {
        super();
        this.name = "Fire Claws";
        this.power = 55;
        this.variance = 5;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.CLAW);
        this.characteristics = Collections.emptyList();
    }
}
