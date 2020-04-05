package com.argentstew.simulator.battle.vg.scorpion;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.scorpion
 * 8/27/2019
 *
 * @author Craig
 */
public class Uppercut extends MeleeAttack {

    public Uppercut() {
        super();
        this.name = "Uppercut";
        this.power = 70;
        this.variance = 7;
        this.speed = 1.5;
        this.subtypes = Collections.singletonList(AttackSubType.PUNCH);
        this.characteristics = Collections.emptyList();
    }
}
