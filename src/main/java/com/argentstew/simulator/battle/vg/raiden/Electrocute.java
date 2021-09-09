package com.argentstew.simulator.battle.vg.raiden;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.raiden
 * 8/27/2019
 *
 * @author Craig
 */
public class Electrocute extends MeleeAttack {

    public Electrocute() {
        super();
        this.name = "Electrocute";
        this.power = 50;
        this.variance = 5;
        this.speed = 1.5;
        this.subtypes = Arrays.asList(AttackSubType.GRAPPLE, AttackSubType.THUNDER);
        this.characteristics = Collections.singletonList(AttackCharacteristic.HOLD);
    }
}
