package com.argentstew.simulator.battle.vg.joker;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.joker
 * 8/27/2019
 *
 * @author Craig
 */
public class Matarunda extends MeleeAttack {

    public static final int MIN_STRENGTH = 2;

    public Matarunda() {
        super();
        this.name = "Matarunda";
        this.description = "Requires Orpheus; reduces the opponent's strength by 2 to a minimum of 1 on hit";
        this.power = 40;
        this.variance = 3;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.SLASH);
        this.characteristics = Collections.emptyList();
    }

    @Override
    public DamageReport doAttack(Fighter defender) {
        DamageReport damageReport = super.doAttack(defender);
        if (!damageReport.isMiss() && damageReport.getDamage() > 0) {
            double strengthUpdate = defender.getStats().getStrength() - MIN_STRENGTH;
            defender.getStats().setStrength(strengthUpdate > MIN_STRENGTH ? strengthUpdate : MIN_STRENGTH);
        }

        return damageReport;
    }

    @Override
    public boolean isAllowed() {
        return Joker.PERSONA_ORPHEUS.equals(owner.getSelfStatus());
    }
}
