package com.argentstew.simulator.battle.vg.lloyd;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.lloyd
 * 8/27/2019
 *
 * @author Craig
 */
public class SwordRain extends MeleeAttack {

    public SwordRain() {
        super();
        this.name = "Sword Rain";
        this.power = 30;
        this.variance = 8;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.PIERCE);
        this.characteristics = Collections.emptyList();
    }
}
