package com.argentstew.simulator.battle.vg.crono;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MagicAttack;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.crono
 * 8/27/2019
 *
 * @author Craig
 */
public class Lightning extends MagicAttack {

    public static final int MP_COST = 2;

    public Lightning() {
        super();
        this.name = "Lightning";
        this.description = "Costs 2 SP";
        this.power = 80;
        this.variance = 7;
        this.speed = 1;
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
