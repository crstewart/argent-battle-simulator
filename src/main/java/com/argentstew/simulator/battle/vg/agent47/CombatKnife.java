package com.argentstew.simulator.battle.vg.agent47;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.agent47
 * 8/24/2019
 *
 * @author Craig
 */
public class CombatKnife extends MeleeAttack {

    public CombatKnife() {
        super();
        this.name = "Combat Knife";
        this.power = 55;
        this.variance = 5;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.SLASH);
        this.characteristics = Collections.emptyList();
    }
}
