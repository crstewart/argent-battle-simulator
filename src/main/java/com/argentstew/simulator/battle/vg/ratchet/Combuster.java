package com.argentstew.simulator.battle.vg.ratchet;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.ratchet
 * 8/24/2019
 *
 * @author Craig
 */
public class Combuster extends RangedAttack {

    public Combuster() {
        super();
        this.name = "Combuster";
        this.power = 60;
        this.variance = 5;
        this.speed = 1.5;
        this.subtypes = Collections.singletonList(AttackSubType.FIRE);
        this.characteristics = Collections.emptyList();
    }
}
