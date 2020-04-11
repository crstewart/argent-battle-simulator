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
public class PlasmaGun extends RangedAttack {

    public PlasmaGun() {
        super();
        this.name = "Plasma Gun";
        this.power = 50;
        this.variance = 10;
        this.speed = 1.5;
        this.subtypes = Collections.singletonList(AttackSubType.PLASMA);
        this.characteristics = Collections.singletonList(AttackCharacteristic.BULLET_SPEED);
    }
}
