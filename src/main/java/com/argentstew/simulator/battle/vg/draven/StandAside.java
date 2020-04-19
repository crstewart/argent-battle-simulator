package com.argentstew.simulator.battle.vg.draven;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;
import com.argentstew.simulator.battle.fighter.Fighter;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.draven
 * 8/24/2019
 *
 * @author Craig
 */
public class StandAside extends RangedAttack {

    public StandAside() {
        super();
        this.name = "Stand Aside";
        this.description = "Has 150% normal stun chance";
        this.power = 55;
        this.variance = 6;
        this.speed = 1.5;
        this.subtypes = Collections.singletonList(AttackSubType.HACK);
        this.characteristics = Collections.emptyList();
    }

    @Override
    public double getStunChance(Fighter defender, boolean isCrit) {
        return super.getStunChance(defender, isCrit) * 1.5;
    }

    @Override
    public double getCritMultiplier(Fighter defender) {
        return 2.5;
    }
}
