package com.argentstew.simulator.battle.vg.crono;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.crono
 * 8/26/2019
 *
 * @author Craig
 */
public class WindSlash extends RangedAttack {

    public static final int MP_COST = 2;

    public WindSlash() {
        super();
        this.name = "Wind Slash";
        this.description = "Costs 2 SP";
        this.power = 75;
        this.variance = 7;
        this.speed = 0.5;
        this.subtypes = Collections.singletonList(AttackSubType.AIR);
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
