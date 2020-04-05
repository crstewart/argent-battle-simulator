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
public class GrenadeEgg extends RangedAttack {

    public GrenadeEgg() {
        super();
        this.name = "Grenade Egg";
        this.power = 60;
        this.variance = 8;
        this.speed = 2;
        this.subtypes = Collections.singletonList(AttackSubType.EXPLOSIVE);
        this.characteristics = Collections.emptyList();
    }
}
