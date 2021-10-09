package com.argentstew.simulator.battle.vg.palutena;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;
import com.argentstew.simulator.battle.status.StatusEffect;
import com.argentstew.simulator.battle.status.StatusType;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.palutena
 * 8/27/2019
 *
 * @author Craig
 */
public class BurnAttack extends RangedAttack {

    private static final int EQUIP_COST = 6;

    private boolean used = false;

    public BurnAttack() {
        super();
        this.name = "Burn Attack";
        this.description = "Costs 6 SP to equip; applies burn for 5 turns on hit";
        this.power = 30;
        this.variance = 3;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.FIRE);
        this.characteristics = Collections.emptyList();
    }

    @Override
    public DamageReport doAttack(Fighter defender) {
        if (!used) {
            used = true;
            owner.useMagic(EQUIP_COST);
        }

        DamageReport damageReport = super.doAttack(defender);
        if (!damageReport.isMiss()) {
            defender.setStatus(new StatusEffect(StatusType.BURN, 5));
        }

        return damageReport;
    }

    @Override
    public boolean isAllowed() {
        return used || owner.getMp() >= EQUIP_COST;
    }
}
