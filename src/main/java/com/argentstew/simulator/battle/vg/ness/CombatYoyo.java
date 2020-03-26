package com.argentstew.simulator.battle.vg.ness;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.ness
 * 8/27/2019
 *
 * @author Craig
 */
public class CombatYoyo extends MeleeAttack {

    public CombatYoyo() {
        super();
        this.name = "Combat Yo-Yo";
        this.power = 75;
        this.variance = 6;
        this.speed = 0.5;
        this.subtypes = Collections.singletonList(AttackSubType.SMASH);
        this.characteristics = Collections.emptyList();
    }
}
