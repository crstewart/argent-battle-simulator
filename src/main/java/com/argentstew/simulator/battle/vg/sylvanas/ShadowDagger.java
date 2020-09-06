package com.argentstew.simulator.battle.vg.sylvanas;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;
import com.argentstew.simulator.battle.fighter.Fighter;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.sylvanas
 * 8/24/2019
 *
 * @author Craig
 */
public class ShadowDagger extends RangedAttack {

    public ShadowDagger() {
        super();
        this.name = "Shadow Dagger";
        this.description = "Has 50% bonus stun chance";
        this.power = 20;
        this.variance = 8;
        this.speed = 0.5;
        this.subtypes = Collections.singletonList(AttackSubType.SLASH);
        this.characteristics = Collections.emptyList();
    }

    @Override
    protected double getStunChance(Fighter defender, boolean isCrit) {
        return super.getStunChance(defender, isCrit) * 1.5;
    }
}
