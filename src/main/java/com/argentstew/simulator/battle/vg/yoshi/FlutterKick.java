package com.argentstew.simulator.battle.vg.yoshi;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.yoshi
 * 8/26/2019
 *
 * @author Craig
 */
public class FlutterKick extends MeleeAttack {

    public FlutterKick() {
        super();
        this.name = "Flutter Kick";
        this.power = 50;
        this.variance = 12;
        this.speed = 2;
        this.subtypes = Collections.singletonList(AttackSubType.KICK);
        this.characteristics = Collections.emptyList();
    }
}
