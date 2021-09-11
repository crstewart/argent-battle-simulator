package com.argentstew.simulator.battle.vg.rosalina;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;
import com.argentstew.simulator.battle.trait.impl.StarGuidance;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.rosalina
 * 8/27/2019
 *
 * @author Craig
 */
public class StarBits extends RangedAttack {

    public StarBits() {
        super();
        this.name = "Star Bits";
        this.description = "Requires a summoned Luma";
        this.power = 30;
        this.variance = 8;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.SLAM);
        this.characteristics = Collections.emptyList();
    }

    @Override
    public boolean isAllowed() {
        StarGuidance starGuidance = owner.getTraits().getTrait(StarGuidance.class);
        if (starGuidance != null) {
            return starGuidance.isReady();
        }

        return false;
    }
}
