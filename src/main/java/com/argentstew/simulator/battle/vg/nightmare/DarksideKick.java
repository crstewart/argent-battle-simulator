package com.argentstew.simulator.battle.vg.nightmare;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.nightmare
 * 8/27/2019
 *
 * @author Craig
 */
public class DarksideKick extends MeleeAttack {

    public DarksideKick() {
        super();
        this.name = "Darkside Kick";
        this.power = 45;
        this.variance = 4;
        this.speed = 0.5;
        this.subtypes = Collections.singletonList(AttackSubType.KICK);
        this.characteristics = Collections.emptyList();
    }
}
