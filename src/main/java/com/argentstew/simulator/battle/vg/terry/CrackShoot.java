package com.argentstew.simulator.battle.vg.terry;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.terry
 * 8/24/2019
 *
 * @author Craig
 */
public class CrackShoot extends MeleeAttack {

    public CrackShoot() {
        super();
        this.name = "Crack Shoot";
        this.power = 45;
        this.variance = 7;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.KICK);
        this.characteristics = Collections.emptyList();
    }
}
