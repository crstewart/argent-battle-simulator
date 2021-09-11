package com.argentstew.simulator.battle.vg.joker;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;
import com.argentstew.simulator.battle.status.StatusEffect;
import com.argentstew.simulator.battle.status.StatusType;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.joker
 * 8/27/2019
 *
 * @author Craig
 */
public class DreamNeedle extends RangedAttack {

    public DreamNeedle() {
        super();
        this.name = "Dream Needle";
        this.description = "Requires Arsene, applies sleep status on hit";
        this.power = 10;
        this.variance = 2;
        this.speed = 0.5;
        this.subtypes = Collections.singletonList(AttackSubType.PIERCE);
        this.characteristics = Collections.emptyList();
    }

    @Override
    public DamageReport doAttack(Fighter defender) {
        DamageReport damageReport = super.doAttack(defender);
        if (!damageReport.isMiss() && damageReport.getDamage() > 0) {
            defender.setStatus(new StatusEffect(StatusType.SLEEP, 3));
        }

        return damageReport;
    }

    @Override
    public boolean isAllowed() {
        return Joker.PERSONA_ARSENE.equals(owner.getSelfStatus());
    }
}
