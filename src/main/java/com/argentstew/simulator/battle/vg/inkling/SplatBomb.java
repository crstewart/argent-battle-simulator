package com.argentstew.simulator.battle.vg.inkling;

import com.argentstew.simulator.battle.action.Action;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.inkling
 * 8/27/2019
 *
 * @author Craig
 */
public class SplatBomb extends RangedAttack {

    public static final int MP_COST = 30;

    public SplatBomb() {
        super();
        this.name = "Splat Bomb";
        this.description = "Uses 30 SP";
        this.power = 110;
        this.variance = 8;
        this.speed = 1.5;
        this.subtypes = Arrays.asList(AttackSubType.TOXIC, AttackSubType.EXPLOSIVE);
        this.characteristics = Collections.emptyList();
    }

    @Override
    public DamageReport doAttack(Fighter defender) {
        owner.useMagic(MP_COST);
        for (Action action : owner.getActions()) {
            if ("Refill Ink".equals(action.getName())) {
                owner.getStrategy().adjustWeight(action, 0.6);
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
