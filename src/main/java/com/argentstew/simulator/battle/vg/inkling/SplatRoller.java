package com.argentstew.simulator.battle.vg.inkling;

import com.argentstew.simulator.battle.action.Action;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;
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
public class SplatRoller extends MeleeAttack {

    public static final int MP_COST = 25;

    public SplatRoller() {
        super();
        this.name = "Splat Roller";
        this.power = 70;
        this.variance = 6;
        this.speed = 1;
        this.subtypes = Arrays.asList(AttackSubType.TOXIC, AttackSubType.SMASH);
        this.characteristics = Collections.emptyList();
    }

    @Override
    public DamageReport doAttack(Fighter defender) {
        owner.useMagic(MP_COST);
        for (Action action : owner.getActions()) {
            if ("Refill Ink".equals(action.getName())) {
                owner.getStrategy().adjustWeight(action, 0.5);
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
