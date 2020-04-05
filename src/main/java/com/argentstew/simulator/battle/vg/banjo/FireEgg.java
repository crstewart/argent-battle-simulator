package com.argentstew.simulator.battle.vg.banjo;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;
import com.argentstew.simulator.battle.action.attack.RangedAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.banjo
 * 9/8/2019
 *
 * @author Craig
 */
public class FireEgg extends RangedAttack {

    public FireEgg() {
        super();
        this.name = "Fire Egg";
        this.power = 50;
        this.variance = 6;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.FIRE);
        this.characteristics = Collections.emptyList();
    }
}
