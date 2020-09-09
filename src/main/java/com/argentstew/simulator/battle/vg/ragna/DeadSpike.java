package com.argentstew.simulator.battle.vg.ragna;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;
import com.argentstew.simulator.battle.action.attack.RangedAttack;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.ragna
 * 8/24/2019
 *
 * @author Craig
 */
public class DeadSpike extends RangedAttack {

    public DeadSpike() {
        super();
        this.name = "Dead Spike";
        this.description = "Heals for 20% of the damage dealt";
        this.power = 35;
        this.variance = 5;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.DARK);
        this.characteristics = Collections.emptyList();
    }

    @Override
    public DamageReport doAttack(Fighter defender) {
        DamageReport report = super.doAttack(defender);
        this.owner.heal(report.getDamage() / 5);
        return report;
    }
}
