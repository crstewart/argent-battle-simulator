package com.argentstew.simulator.battle.vg.amaterasu;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.amaterasu
 * 8/24/2019
 *
 * @author Craig
 */
public class HeadCharge extends MeleeAttack {

    public HeadCharge() {
        super();
        this.name = "Head Charge";
        this.power = 45;
        this.variance = 5;
        this.speed = 0.5;
        this.subtypes = Collections.singletonList(AttackSubType.HEADBUTT);
        this.characteristics = Collections.emptyList();
    }
}
