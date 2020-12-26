package com.argentstew.simulator.battle.vg.pacman;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.pacman
 * 8/27/2019
 *
 * @author Craig
 */
public class PacBite extends MeleeAttack {

    public PacBite() {
        super();
        this.name = "Pac Bite";
        this.power = 80;
        this.variance = 8;
        this.speed = 1.5;
        this.subtypes = Collections.singletonList(AttackSubType.BITE);
        this.characteristics = Collections.singletonList(AttackCharacteristic.UNGUARDABLE);
    }
}
