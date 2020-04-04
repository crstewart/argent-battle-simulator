package com.argentstew.simulator.battle.vg.handsomejack;

import com.argentstew.simulator.battle.action.AttackAction;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.fighter.FighterClassification;
import com.argentstew.simulator.battle.reporting.DamageReport;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.handsomejack
 * 8/27/2019
 *
 * @author Craig
 */
public class IncendiaryBeam extends RangedAttack {

    public IncendiaryBeam() {
        super();
        this.name = "Incendiary Beam";
        this.power = 60;
        this.variance = 6;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.FIRE);
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
        if (defender.getClassifications().contains(FighterClassification.HUMANOID)
                || defender.getClassifications().contains(FighterClassification.ANIMAL)) {
            return (int) Math.round(damage * 1.2);
        }

        return damage;
    }
}
