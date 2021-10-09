package com.argentstew.simulator.battle.vg.palutena;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MagicAttack;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.palutena
 * 8/27/2019
 *
 * @author Craig
 */
public class WeakpointReticle extends MagicAttack {

    private static final int EQUIP_COST = 6;

    private boolean used = false;

    public WeakpointReticle() {
        super();
        this.name = "Weak-point Reticle";
        this.description = "Costs 6 SP to equip; has 50% critical hit chance";
        this.power = 40;
        this.variance = 4;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.LIGHT);
        this.characteristics = Collections.emptyList();
    }

    @Override
    public DamageReport doAttack(Fighter defender) {
        if (!used) {
            used = true;
            owner.useMagic(EQUIP_COST);
        }

        return super.doAttack(defender);
    }

    @Override
    public double getCritChance(Fighter defender) {
        return 0.5;
    }

    @Override
    public boolean isAllowed() {
        return used || owner.getMp() >= EQUIP_COST;
    }
}
