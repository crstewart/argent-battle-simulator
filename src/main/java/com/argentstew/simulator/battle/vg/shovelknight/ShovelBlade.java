package com.argentstew.simulator.battle.vg.shovelknight;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.shovelknight
 * 8/27/2019
 *
 * @author Craig
 */
public class ShovelBlade extends MeleeAttack {

    public ShovelBlade() {
        super();
        this.name = "Shovel Blade";
        this.power = 40;
        this.variance = 4;
        this.speed = 0.5;
        this.subtypes = Collections.singletonList(AttackSubType.SLASH);
        this.characteristics = Collections.emptyList();
    }
}
