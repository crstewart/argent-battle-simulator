package com.argentstew.simulator.battle.vg.nathandrake;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.nathandrake
 * 8/27/2019
 *
 * @author Craig
 */
public class SteelFist extends MeleeAttack {

    public SteelFist() {
        super();
        this.name = "Steel Fist";
        this.power = 50;
        this.variance = 5;
        this.speed = 0.5;
        this.subtypes = Collections.singletonList(AttackSubType.PUNCH);
        this.characteristics = Collections.emptyList();
    }
}
