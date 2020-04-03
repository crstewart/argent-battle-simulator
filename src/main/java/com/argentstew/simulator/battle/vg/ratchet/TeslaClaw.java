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
public class TeslaClaw extends RangedAttack {

    public TeslaClaw() {
        super();
        this.name = "Tesla Claw";
        this.power = 45;
        this.variance = 4;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.THUNDER);
        this.characteristics = Collections.singletonList(AttackCharacteristic.UNDODGEABLE);
    }
}
