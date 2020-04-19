package com.argentstew.simulator.battle.vg.donkeykong;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;
import com.argentstew.simulator.battle.action.attack.RangedAttack;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.donkeykong
 * 8/26/2019
 *
 * @author Craig
 */
public class BarrelToss extends RangedAttack {

    public static final int MP_COST = 1;

    public BarrelToss() {
        super();
        this.name = "Barrel Toss";
        this.description = "Costs 1 SP";
        this.power = 65;
        this.variance = 6;
        this.speed = 3;
        this.subtypes = Collections.singletonList(AttackSubType.SMASH);
        this.characteristics = Collections.emptyList();
    }

    @Override
    public DamageReport doAttack(Fighter defender) {
        owner.useMagic(MP_COST);
        return super.doAttack(defender);
    }

    @Override
    public boolean isDoable() {
        return owner.getMp() >= MP_COST;
    }
}
