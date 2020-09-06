package com.argentstew.simulator.battle.vg.greninja;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;
import com.argentstew.simulator.battle.trait.impl.Protean;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.greninja
 * 9/7/2019
 *
 * @author Craig
 */
public class NightSlash extends RangedAttack {

    public NightSlash() {
        super();
        this.name = "Night Slash";
        this.description = "Has double critical hit chance";
        this.power = 70;
        this.variance = 6;
        this.speed = 1.5;
        this.subtypes = Collections.singletonList(AttackSubType.DARK);
        this.characteristics = Collections.emptyList();
    }

    @Override
    public DamageReport doAttack(Fighter defender) {
        Protean trait = (Protean) this.owner.getTraits().getTraits().get(0);
        trait.setState(Protean.DARK_TYPE);
        return super.doAttack(defender);
    }

    @Override
    protected double getCritChance(Fighter defender) {
        double baseCritChance = super.getCritChance(defender);
        return baseCritChance * 2;
    }
}
