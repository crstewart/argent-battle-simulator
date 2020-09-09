package com.argentstew.simulator.battle.vg.heihachi;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.heihachi
 * 8/24/2019
 *
 * @author Craig
 */
public class TsunamiKick extends MeleeAttack {

    public TsunamiKick() {
        super();
        this.name = "Tsunami Kick";
        this.power = 70;
        this.variance = 5;
        this.speed = 1.5;
        this.subtypes = Collections.singletonList(AttackSubType.KICK);
        this.characteristics = Collections.emptyList();
    }
}
