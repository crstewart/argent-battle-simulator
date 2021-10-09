package com.argentstew.simulator.battle.vg.tyrael;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;
import com.argentstew.simulator.battle.status.StatusEffect;
import com.argentstew.simulator.battle.status.StatusType;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.tyrael
 * 8/27/2019
 *
 * @author Craig
 */
public class DivineReckoning extends RangedAttack {

    public DivineReckoning() {
        super();
        this.name = "Divine Reckoning";
        this.description = "Applies slow for 3 turns on hit";
        this.power = 50;
        this.variance = 5;
        this.speed = 3;
        this.subtypes = Arrays.asList(AttackSubType.LIGHT, AttackSubType.SLASH);
        this.characteristics = Collections.emptyList();
    }

    @Override
    public DamageReport doAttack(Fighter defender) {
        DamageReport damageReport = super.doAttack(defender);
        if (!damageReport.isMiss()) {
            defender.setStatus(new StatusEffect(StatusType.SLOW, 5));
        }

        return damageReport;
    }
}
