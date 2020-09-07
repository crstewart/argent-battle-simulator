package com.argentstew.simulator.battle.vg.teemo;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MagicAttack;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.fighter.FighterClassification;
import com.argentstew.simulator.battle.reporting.DamageReport;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.teemo
 * 8/27/2019
 *
 * @author Craig
 */
public class ToxicShot extends MagicAttack {

    public ToxicShot() {
        super();
        this.name = "Toxic Shot";
        this.description = "Deals 50% bonus damage against monsters";
        this.power = 50;
        this.variance = 4;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.TOXIC);
        this.characteristics = Collections.singletonList(AttackCharacteristic.STEALTH);
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
        if (defender.getClassifications().contains(FighterClassification.MONSTER)) {
            return (int) Math.round(damage * 1.5);
        }

        return damage;
    }
}
