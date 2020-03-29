package com.argentstew.simulator.battle.vg.cloud;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;
import com.argentstew.simulator.battle.action.attack.RangedAttack;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.cloud
 * 8/24/2019
 *
 * @author Craig
 */
public class CrossSlash extends MeleeAttack {

    public CrossSlash() {
        super();
        this.name = "Cross-slash";
        this.power = 50;
        this.variance = 15;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.SLASH);
        this.characteristics = Collections.emptyList();
    }

    @Override
    public DamageReport doAttack(Fighter defender) {
        int mp = this.owner.getMp();
        this.owner.setMp(Math.min(mp + 2, this.owner.getMaxMp()));
        return super.doAttack(defender);
    }

    @Override
    public boolean isDoable() {
        return this.owner.getMp() < this.owner.getMaxMp();
    }
}
