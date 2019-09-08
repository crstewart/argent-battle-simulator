package com.argentstew.simulator.battle.vg.pikachu;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.pikachu
 * 9/7/2019
 *
 * @author Craig
 */
public class QuickAttack extends MeleeAttack {

    public QuickAttack() {
        super();
        this.name = "Quick Attack";
        this.power = 40;
        this.variance = 3;
        this.speed = 0;
        this.subtypes = Collections.singletonList(AttackSubType.SLAM);
        this.characteristics = Collections.singletonList(AttackCharacteristic.UNDODGEABLE);
    }
}
