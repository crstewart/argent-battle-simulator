package com.argentstew.simulator.battle.vg.ganondorf;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.ganondorf
 * 9/7/2019
 *
 * @author Craig
 */
public class FlameChoke extends MeleeAttack {

    public FlameChoke() {
        super();
        this.name = "Flame Choke";
        this.power = 70;
        this.variance = 6;
        this.speed = 1.5;
        this.subtypes = Arrays.asList(AttackSubType.GRAPPLE, AttackSubType.DARK);
        this.characteristics = Collections.singletonList(AttackCharacteristic.UNGUARDABLE);
    }
}
