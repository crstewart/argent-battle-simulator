package com.argentstew.simulator.battle.vg.link;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.link
 * 8/27/2019
 *
 * @author Craig
 */
public class Hookshot extends RangedAttack {

    public Hookshot() {
        super();
        this.name = "Hookshot";
        this.power = 50;
        this.variance = 5;
        this.speed = 2.5;
        this.subtypes = Arrays.asList(AttackSubType.PIERCE, AttackSubType.GRAPPLE);
        this.characteristics = Collections.singletonList(AttackCharacteristic.UNGUARDABLE);
    }
}
