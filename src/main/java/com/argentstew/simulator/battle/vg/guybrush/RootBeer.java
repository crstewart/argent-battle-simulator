package com.argentstew.simulator.battle.vg.guybrush;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MagicAttack;
import com.argentstew.simulator.battle.action.attack.RangedAttack;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.fighter.FighterClassification;
import com.argentstew.simulator.battle.reporting.DamageReport;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.guybrush
 * 8/27/2019
 *
 * @author Craig
 */
public class RootBeer extends RangedAttack {

    public RootBeer() {
        super();
        this.name = "Root Beer";
        this.description = "Deals double damage to undead";
        this.power = 60;
        this.variance = 6;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.TOXIC);
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
        if (defender.getClassifications().contains(FighterClassification.UNDEAD)) {
            return (int) Math.round(damage * 2);
        }

        return damage;
    }
}
