package com.argentstew.simulator.battle.vg.doomslayer;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.doomslayer
 * 8/24/2019
 *
 * @author Craig
 */
public class RocketLauncher extends RangedAttack {

    public RocketLauncher() {
        super();
        this.name = "Rocket Launcher";
        this.power = 80;
        this.variance = 8;
        this.speed = 2.5;
        this.subtypes = Collections.singletonList(AttackSubType.EXPLOSIVE);
        this.characteristics = Collections.emptyList();
    }
}
