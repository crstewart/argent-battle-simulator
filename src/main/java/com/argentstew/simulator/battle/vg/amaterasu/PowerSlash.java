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
public class PowerSlash extends MeleeAttack {

    public PowerSlash() {
        super();
        this.name = "Power Slash";
        this.power = 75;
        this.variance = 8;
        this.speed = 2;
        this.subtypes = Collections.singletonList(AttackSubType.SLASH);
        this.characteristics = Collections.emptyList();
    }
}
