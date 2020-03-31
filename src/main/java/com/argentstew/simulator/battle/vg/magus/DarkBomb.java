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
public class DarkBomb extends MagicAttack {

    public DarkBomb() {
        super();
        this.name = "Dark Bomb";
        this.power = 80;
        this.variance = 8;
        this.speed = 2.5;
        this.subtypes = Collections.singletonList(AttackSubType.DARK);
        this.characteristics = Collections.emptyList();
    }

    @Override
    public DamageReport doAttack(Fighter defender) {
        if (!owner.getTraits().getTraits().isEmpty()) {
            BarrierChange trait = (BarrierChange) this.owner.getTraits().getTraits().get(0);
            trait.setLastElementUsed(AttackSubType.DARK);
        }

        return super.doAttack(defender);
    }
}
