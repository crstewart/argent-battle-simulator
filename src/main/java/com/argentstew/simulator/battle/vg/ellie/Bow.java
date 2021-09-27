package com.argentstew.simulator.battle.vg.ellie;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.ellie
 * 8/27/2019
 *
 * @author Craig
 */
public class Bow extends RangedAttack {

    public Bow() {
        super();
        this.name = "Bow";
        this.power = 45;
        this.variance = 4;
        this.speed = 2;
        this.subtypes = Collections.singletonList(AttackSubType.PIERCE);
        this.characteristics = Collections.singletonList(AttackCharacteristic.STEALTH);
    }
}
