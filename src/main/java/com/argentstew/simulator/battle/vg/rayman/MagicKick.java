package com.argentstew.simulator.battle.vg.rayman;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.rayman
 * 8/24/2019
 *
 * @author Craig
 */
public class MagicKick extends MeleeAttack {

    public MagicKick() {
        super();
        this.name = "Magic Kick";
        this.power = 65;
        this.variance = 5;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.KICK);
        this.characteristics = Collections.emptyList();
    }
}
