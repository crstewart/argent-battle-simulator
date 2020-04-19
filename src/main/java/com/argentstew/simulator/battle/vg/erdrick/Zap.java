package com.argentstew.simulator.battle.vg.erdrick;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MagicAttack;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.erdrick
 * 8/27/2019
 *
 * @author Craig
 */
public class Zap extends MagicAttack {

    public static final int MP_COST = 8;

    public Zap() {
        super();
        this.name = "Zap";
        this.description = "Costs 8 SP";
        this.power = 120;
        this.variance = 10;
        this.speed = 3;
        this.subtypes = Collections.singletonList(AttackSubType.THUNDER);
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
