package com.argentstew.simulator.battle.vg.wolf;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.wolf
 * 8/24/2019
 *
 * @author Craig
 */
public class WolfFlash extends MeleeAttack {

    public WolfFlash() {
        super();
        this.name = "Wolf Flash";
        this.power = 50;
        this.variance = 10;
        this.speed = 0;
        this.subtypes = Collections.singletonList(AttackSubType.SLAM);
        this.characteristics = Collections.emptyList();
    }
}
