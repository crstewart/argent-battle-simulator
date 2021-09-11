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
public class LumaShot extends RangedAttack {

    public LumaShot() {
        super();
        this.name = "Luma Shot";
        this.description = "Requires a summoned Luma";
        this.power = 50;
        this.variance = 5;
        this.speed = 2;
        this.subtypes = Collections.singletonList(AttackSubType.HEADBUTT);
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
