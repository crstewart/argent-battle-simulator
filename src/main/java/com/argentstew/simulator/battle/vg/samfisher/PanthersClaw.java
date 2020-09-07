package com.argentstew.simulator.battle.vg.samfisher;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.samfisher
 * 8/24/2019
 *
 * @author Craig
 */
public class PanthersClaw extends MeleeAttack {

    public PanthersClaw() {
        super();
        this.name = "\"Panther's Claw\" Karambit";
        this.power = 50;
        this.variance = 5;
        this.speed = 0.5;
        this.subtypes = Collections.singletonList(AttackSubType.SLASH);
        this.characteristics = Collections.emptyList();
    }
}
