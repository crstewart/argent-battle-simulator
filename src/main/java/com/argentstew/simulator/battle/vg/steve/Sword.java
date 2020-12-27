package com.argentstew.simulator.battle.vg.steve;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.steve
 * 8/27/2019
 *
 * @author Craig
 */
public class Sword extends MeleeAttack {

    public Sword() {
        super();
        this.name = "Sword";
        this.power = 55;
        this.variance = 7;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.SLASH);
        this.characteristics = Collections.emptyList();
    }
}
