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
public class HeavenlyLight extends MagicAttack {

    private static final int EQUIP_COST = 7;

    private boolean used = false;

    public HeavenlyLight() {
        super();
        this.name = "Heavenly Light";
        this.description = "Costs 7 SP to equip";
        this.power = 50;
        this.variance = 6;
        this.speed = 0.5;
        this.requiresMeleeRange = true;
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
    public boolean isAllowed() {
        return used || owner.getMp() >= EQUIP_COST;
    }
}
