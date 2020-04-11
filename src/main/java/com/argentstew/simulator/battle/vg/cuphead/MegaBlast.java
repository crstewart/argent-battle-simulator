package com.argentstew.simulator.battle.vg.cuphead;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MagicAttack;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.cuphead
 * 8/27/2019
 *
 * @author Craig
 */
public class MegaBlast extends MagicAttack {

    public static final int MP_COST = 2;

    public MegaBlast() {
        super();
        this.name = "Mega Blast";
        this.power = 120;
        this.variance = 12;
        this.speed = 2;
        this.subtypes = Collections.emptyList();
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
