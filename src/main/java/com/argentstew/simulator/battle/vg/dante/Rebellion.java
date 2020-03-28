package com.argentstew.simulator.battle.vg.dante;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.dante
 * 8/27/2019
 *
 * @author Craig
 */
public class Rebellion extends MeleeAttack {

    public Rebellion() {
        super();
        this.name = "Rebellion";
        this.power = 55;
        this.variance = 5;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.SLASH);
        this.characteristics = Collections.emptyList();
    }
}
