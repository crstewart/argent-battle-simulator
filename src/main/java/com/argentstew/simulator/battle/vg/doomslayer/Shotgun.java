package com.argentstew.simulator.battle.vg.doomslayer;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;
import com.argentstew.simulator.battle.action.attack.RangedAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.doomslayer
 * 8/24/2019
 *
 * @author Craig
 */
public class Shotgun extends RangedAttack {

    public Shotgun() {
        super();
        this.name = "Shotgun";
        this.power = 70;
        this.variance = 7;
        this.speed = 2;
        this.subtypes = Collections.singletonList(AttackSubType.SHOTGUN);
        this.characteristics = Collections.singletonList(AttackCharacteristic.BULLET_SPEED);
    }
}
