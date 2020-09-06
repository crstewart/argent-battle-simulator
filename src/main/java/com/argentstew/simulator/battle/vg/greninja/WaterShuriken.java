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
public class WaterShuriken extends RangedAttack {

    public WaterShuriken() {
        super();
        this.name = "Water Shuriken";
        this.power = 45;
        this.variance = 15;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.WATER);
        this.characteristics = Collections.emptyList();
    }

    @Override
    public DamageReport doAttack(Fighter defender) {
        if (this.owner.getTraits().has(new Protean())) {
            Protean trait = (Protean) this.owner.getTraits().getTraits().get(0);
            trait.setState(Protean.WATER_TYPE);
        }
        return super.doAttack(defender);
    }
}
