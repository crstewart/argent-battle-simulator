package com.argentstew.simulator.battle.vg.shovelknight;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MagicAttack;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.shovelknight
 * 8/27/2019
 *
 * @author Craig
 */
public class ChaosSphere extends MagicAttack {

    private static final int MP_COST = 6;

    public ChaosSphere() {
        super();
        this.name = "Chaos Sphere";
        this.power = 75;
        this.variance = 7;
        this.speed = 1;
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
