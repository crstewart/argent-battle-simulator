package com.argentstew.simulator.battle.vg.vyse;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.vyse
 * 8/27/2019
 *
 * @author Craig
 */
public class CutlassFury extends MeleeAttack {

    public static final int MP_COST = 7;

    public CutlassFury() {
        super();
        this.name = "Cutlass Fury";
        this.description = "Uses 7 SP";
        this.power = 125;
        this.variance = 10;
        this.speed = 2;
        this.subtypes = Collections.singletonList(AttackSubType.SLASH);
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
