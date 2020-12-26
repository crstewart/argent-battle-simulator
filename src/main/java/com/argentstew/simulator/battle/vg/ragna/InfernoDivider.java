package com.argentstew.simulator.battle.vg.ragna;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;
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
public class InfernoDivider extends MeleeAttack {

    public InfernoDivider() {
        super();
        this.name = "Inferno Divider";
        this.description = "Heals for 25% of the damage dealt";
        this.power = 45;
        this.variance = 6;
        this.speed = 1.5;
        this.subtypes = Arrays.asList(AttackSubType.SLASH, AttackSubType.DARK);
        this.characteristics = Collections.emptyList();
    }

    @Override
    public DamageReport doAttack(Fighter defender) {
        DamageReport report = super.doAttack(defender);
        this.owner.heal(report.getDamage() / 4);
        return report;
    }
}
