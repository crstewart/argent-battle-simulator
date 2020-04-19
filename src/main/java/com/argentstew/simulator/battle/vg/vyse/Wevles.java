package com.argentstew.simulator.battle.vg.vyse;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MagicAttack;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.vyse
 * 8/24/2019
 *
 * @author Craig
 */
public class Wevles extends MagicAttack {

    public static final int MP_COST = 4;

    public Wevles() {
        super();
        this.name = "Wevles";
        this.description = "Uses 4 SP";
        this.power = 75;
        this.variance = 7;
        this.speed = 2;
        this.subtypes = Arrays.asList(AttackSubType.AIR, AttackSubType.WATER);
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
