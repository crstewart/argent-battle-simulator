package com.argentstew.simulator.battle.vg.pacman;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeXStrike;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.pacman
 * 8/24/2019
 *
 * @author Craig
 */
public class SuperPacMan extends MeleeXStrike {

    public SuperPacMan() {
        super();
        this.name = "Super Pac-Man";
        this.power = 250;
        this.variance = 18;
        this.speed = 3;
        this.subtypes = Collections.singletonList(AttackSubType.BITE);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNGUARDABLE, AttackCharacteristic.UNDODGEABLE);
    }
}
