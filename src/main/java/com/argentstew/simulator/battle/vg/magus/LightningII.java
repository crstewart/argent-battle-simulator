package com.argentstew.simulator.battle.vg.magus;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MagicAttack;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;
import com.argentstew.simulator.battle.trait.impl.BarrierChange;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.magus
 * 8/27/2019
 *
 * @author Craig
 */
public class LightningII extends MagicAttack {

    public LightningII() {
        super();
        this.name = "Lightning II";
        this.power = 70;
        this.variance = 7;
        this.speed = 1.5;
        this.subtypes = Collections.singletonList(AttackSubType.THUNDER);
        this.characteristics = Collections.emptyList();
    }

    @Override
    public DamageReport doAttack(Fighter defender) {
        BarrierChange trait = (BarrierChange) this.owner.getTraits().getTraits().get(0);
        trait.setLastElementUsed(AttackSubType.THUNDER);
        return super.doAttack(defender);
    }
}
