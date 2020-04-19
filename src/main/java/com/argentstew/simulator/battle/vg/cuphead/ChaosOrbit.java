package com.argentstew.simulator.battle.vg.cuphead;

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
public class ChaosOrbit extends MagicAttack {

    public static final int MP_COST = 2;

    public ChaosOrbit() {
        super();
        this.name = "Chaos Orbit";
        this.description = "Costs 2 SP";
        this.power = 60;
        this.variance = 16;
        this.speed = 2;
        this.subtypes = Collections.emptyList();
        this.characteristics = Collections.emptyList();
        this.setRequiresMeleeRange(true);
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
