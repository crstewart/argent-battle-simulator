package com.argentstew.simulator.battle.vg.wario;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.wario
 * 8/27/2019
 *
 * @author Craig
 */
public class Chomp extends MeleeAttack {

    public Chomp() {
        super();
        this.name = "Chomp";
        this.power = 30;
        this.variance = 4;
        this.speed = 1;
        this.subtypes = Arrays.asList(AttackSubType.GRAPPLE, AttackSubType.BITE);
        this.characteristics = Collections.singletonList(AttackCharacteristic.UNGUARDABLE);
    }
}
