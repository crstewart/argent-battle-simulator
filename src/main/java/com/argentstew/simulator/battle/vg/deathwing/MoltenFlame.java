package com.argentstew.simulator.battle.vg.deathwing;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.deathwing
 * 8/24/2019
 *
 * @author Craig
 */
public class MoltenFlame extends RangedAttack {

    public MoltenFlame() {
        super();
        this.name = "Molten Flame";
        this.power = 80;
        this.variance = 8;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.FIRE);
        this.characteristics = Collections.emptyList();
    }
}
