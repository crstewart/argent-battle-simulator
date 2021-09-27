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
public class PoisonAttack extends RangedAttack {

    private static final int EQUIP_COST = 4;

    private boolean used = false;

    public PoisonAttack() {
        super();
        this.name = "Poison Attack";
        this.description = "Applies poison for 3 turns on hit";
        this.power = 15;
        this.variance = 2;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.TOXIC);
        this.characteristics = Collections.emptyList();
    }

    @Override
    public DamageReport doAttack(Fighter defender) {
        if (!used) {
            used = true;
            owner.restoreMagic(EQUIP_COST);
        }

        DamageReport damageReport = super.doAttack(defender);
        if (!damageReport.isMiss()) {
            defender.setStatus(new StatusEffect(StatusType.POISON, 3));
        }

        return super.doAttack(defender);
    }

    @Override
    public boolean isAllowed() {
        return used || owner.getMp() + EQUIP_COST <= owner.getMaxMp();
    }
}
