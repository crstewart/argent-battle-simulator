package com.argentstew.simulator.battle.vg.waluigi;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.waluigi
 * 8/27/2019
 *
 * @author Craig
 */
public class PirahnaPlant extends MeleeAttack {

    public PirahnaPlant() {
        super();
        this.name = "Pirahna Plant";
        this.power = 60;
        this.variance = 8;
        this.speed = 1.5;
        this.subtypes = Collections.singletonList(AttackSubType.BITE);
        this.characteristics = Collections.singletonList(AttackCharacteristic.HOLD);
    }
}
