package com.argentstew.simulator.battle.vg.crono;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.crono
 * 8/27/2019
 *
 * @author Craig
 */
public class Cleave extends MeleeAttack {

    public static final int MP_COST = 4;

    public Cleave() {
        super();
        this.name = "Cleave";
        this.description = "Cost 4 SP";
        this.power = 100;
        this.variance = 10;
        this.speed = 1.5;
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
