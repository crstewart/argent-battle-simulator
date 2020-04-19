package com.argentstew.simulator.battle.vg.cloud;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.cloud
 * 8/24/2019
 *
 * @author Craig
 */
public class CrossSlashLimitBreak extends MeleeAttack {

    public CrossSlashLimitBreak() {
        super();
        this.name = "Cross-slash (Limit Break)";
        this.description = "Uses all SP";
        this.power = 100;
        this.variance = 30;
        this.speed = 0.5;
        this.subtypes = Collections.singletonList(AttackSubType.SLASH);
        this.characteristics = Collections.emptyList();
    }

    @Override
    public DamageReport doAttack(Fighter defender) {
        this.owner.setMp(0);
        return super.doAttack(defender);
    }

    @Override
    public boolean isDoable() {
        return this.owner.getMp() >= this.owner.getMaxMp();
    }
}
