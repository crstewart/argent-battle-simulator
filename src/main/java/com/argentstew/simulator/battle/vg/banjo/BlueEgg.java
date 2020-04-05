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
public class BlueEgg extends RangedAttack {

    public BlueEgg() {
        super();
        this.name = "Blue Egg";
        this.power = 40;
        this.variance = 4;
        this.speed = 0.5;
        this.subtypes = Collections.singletonList(AttackSubType.NATURE);
        this.characteristics = Collections.emptyList();
    }
}
