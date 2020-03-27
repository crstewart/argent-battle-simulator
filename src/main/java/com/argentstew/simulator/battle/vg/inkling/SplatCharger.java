package com.argentstew.simulator.battle.vg.inkling;

import com.argentstew.simulator.battle.action.Action;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.inkling
 * 8/27/2019
 *
 * @author Craig
 */
public class SplatCharger extends RangedAttack {

    public static final int MP_COST = 10;

    public SplatCharger() {
        super();
        this.name = "Splat Charger";
        this.power = 60;
        this.variance = 6;
        this.speed = 2.5;
        this.subtypes = Collections.singletonList(AttackSubType.TOXIC);
        this.characteristics = Collections.emptyList();
    }

    @Override
    protected double getCritChance(Fighter defender) {
        double baseCritChance = super.getCritChance(defender);
        double distanceBetweenFighters = owner.getArena().getDistanceBetweenFighters();
        return baseCritChance * (distanceBetweenFighters / 2.0);
    }

    @Override
    public DamageReport doAttack(Fighter defender) {
        owner.useMagic(MP_COST);
        for (Action action : owner.getActions()) {
            if ("Refill Ink".equals(action.getName())) {
                owner.getStrategy().adjustWeight(action, 0.2);
                break;
            }
        }

        return super.doAttack(defender);
    }

    @Override
    public boolean isDoable() {
        return owner.getMp() >= MP_COST;
    }
}
