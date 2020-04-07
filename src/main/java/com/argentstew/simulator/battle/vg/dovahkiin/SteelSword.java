package com.argentstew.simulator.battle.vg.dovahkiin;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.dovahkiin
 * 8/27/2019
 *
 * @author Craig
 */
public class SteelSword extends MeleeAttack {

    public SteelSword() {
        super();
        this.name = "Steel Sword";
        this.power = 50;
        this.variance = 5;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.SLASH);
        this.characteristics = Collections.emptyList();
    }
}
