package com.argentstew.simulator.battle.vg.laracroft;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.laracroft
 * 8/27/2019
 *
 * @author Craig
 */
public class DualUzis extends RangedAttack {

    public DualUzis() {
        super();
        this.name = "Dual Uzis";
        this.power = 60;
        this.variance = 15;
        this.speed = 2;
        this.subtypes = Collections.singletonList(AttackSubType.RIFLE);
        this.characteristics = Collections.singletonList(AttackCharacteristic.BULLET_SPEED);
    }
}
