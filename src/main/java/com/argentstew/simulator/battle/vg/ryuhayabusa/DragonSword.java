package com.argentstew.simulator.battle.vg.ryuhayabusa;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.ryuhayabusa
 * 8/27/2019
 *
 * @author Craig
 */
public class DragonSword extends MeleeAttack {

    public DragonSword() {
        super();
        this.name = "Dragon Sword";
        this.power = 55;
        this.variance = 5;
        this.speed = 0.5;
        this.subtypes = Collections.singletonList(AttackSubType.SLASH);
        this.characteristics = Collections.emptyList();
    }
}
