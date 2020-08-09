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
public class DualPistols extends RangedAttack {

    public DualPistols() {
        super();
        this.name = "Dual Pistols";
        this.power = 85;
        this.variance = 7;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.HANDGUN);
        this.characteristics = Collections.singletonList(AttackCharacteristic.BULLET_SPEED);
    }
}
