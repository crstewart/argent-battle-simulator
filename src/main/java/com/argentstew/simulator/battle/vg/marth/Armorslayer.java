package com.argentstew.simulator.battle.vg.marth;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.marth
 * 8/27/2019
 *
 * @author Craig
 */
public class Armorslayer extends MeleeAttack {

    public Armorslayer() {
        super();
        this.name = "Armorslayer";
        this.power = 45;
        this.variance = 5;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.SLASH);
        this.characteristics = Collections.singletonList(AttackCharacteristic.UNGUARDABLE);
    }
}
