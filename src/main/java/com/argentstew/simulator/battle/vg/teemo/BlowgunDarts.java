package com.argentstew.simulator.battle.vg.teemo;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.teemo
 * 8/27/2019
 *
 * @author Craig
 */
public class BlowgunDarts extends RangedAttack {

    public BlowgunDarts() {
        super();
        this.name = "Blowgun Darts";
        this.power = 50;
        this.variance = 3;
        this.speed = 2;
        this.subtypes = Collections.singletonList(AttackSubType.PIERCE);
        this.characteristics = Collections.singletonList(AttackCharacteristic.STEALTH);
    }
}
