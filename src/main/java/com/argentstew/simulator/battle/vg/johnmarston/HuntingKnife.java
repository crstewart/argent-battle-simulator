package com.argentstew.simulator.battle.vg.johnmarston;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.johnmarston
 * 8/27/2019
 *
 * @author Craig
 */
public class HuntingKnife extends MeleeAttack {

    public HuntingKnife() {
        super();
        this.name = "Hunting Knife";
        this.power = 50;
        this.variance = 5;
        this.speed = 0.5;
        this.subtypes = Collections.singletonList(AttackSubType.SLASH);
        this.characteristics = Collections.emptyList();
    }
}
