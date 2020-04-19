package com.argentstew.simulator.battle.vg.handsomejack;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.fighter.FighterClassification;
import com.argentstew.simulator.battle.reporting.DamageReport;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.handsomejack
 * 8/27/2019
 *
 * @author Craig
 */
public class CorrosiveGrenade extends RangedAttack {

    public CorrosiveGrenade() {
        super();
        this.name = "Corrosive Grenade";
        this.description = "Deals 25% additional damage to mechs";
        this.power = 70;
        this.variance = 7;
        this.speed = 1.5;
        this.subtypes = Arrays.asList(AttackSubType.TOXIC, AttackSubType.EXPLOSIVE);
        this.characteristics = Collections.emptyList();
    }

    @Override
    public DamageReport doAttack(Fighter defender) {
        DamageReport report = super.doAttack(defender);

        if (report.isMiss()) {
            return report;
        }

        DamageReport adjustedReport = new DamageReport();
        adjustedReport.setDefender(report.getDefender());
        adjustedReport.setAttack(report.getAttack());
        adjustedReport.setMiss(report.isMiss());
        adjustedReport.setCrit(report.isCrit());
        adjustedReport.setStun(report.isStun());
        adjustedReport.setDamage(modifyDamage(defender, report.getDamage()));

        return adjustedReport;
    }

    private int modifyDamage(Fighter defender, int damage) {
        if (defender.getClassifications().contains(FighterClassification.MECH)) {
            return (int) Math.round(damage * 1.25);
        }

        return damage;
    }
}
