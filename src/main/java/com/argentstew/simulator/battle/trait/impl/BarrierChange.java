package com.argentstew.simulator.battle.trait.impl;

import com.argentstew.simulator.battle.action.AttackAction;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;
import com.argentstew.simulator.battle.trait.Trait;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * com.argentstew.simulator.battle.trait.impl
 * 3/30/2020
 *
 * @author argen
 */
@Getter
@EqualsAndHashCode
public class BarrierChange implements Trait {

    private static final List<AttackSubType> ELEMENTS = Collections.unmodifiableList(Arrays.asList(
            AttackSubType.FIRE, AttackSubType.ICE, AttackSubType.THUNDER, AttackSubType.DARK)
    );

    private String name = "Barrier Change";
    private AttackSubType lastElementUsed;

    public BarrierChange() {
        this.lastElementUsed = ELEMENTS.get((int) Math.floor(Math.random() * ELEMENTS.size()));
    }

    @Override
    public double applyBonusDamage(Fighter defender, double rawDamage) {
        return rawDamage;
    }

    @Override
    public AttackAction applyPassiveDefense(AttackAction attack) {
        return null;
    }

    @Override
    public DamageReport applyArmor(DamageReport report) {
        if (report.isMiss()) {
            return report;
        }

        DamageReport adjustedReport = new DamageReport();
        adjustedReport.setDefender(report.getDefender());
        adjustedReport.setAttack(report.getAttack());
        adjustedReport.setMiss(report.isMiss());
        adjustedReport.setCrit(report.isCrit());
        adjustedReport.setStun(report.isStun());
        adjustedReport.setDamage(modifyDamage(report.getAttack(), report.getDamage()));

        return adjustedReport;
    }

    public void setLastElementUsed(AttackSubType lastElementUsed) {
        this.lastElementUsed = lastElementUsed;
    }

    private int modifyDamage(AttackAction attack, int damage) {
        int finalDamage = damage;
        for (AttackSubType subType : attack.getSubtypes()) {
            if (ELEMENTS.contains(subType)) {
                if (subType.equals(lastElementUsed)) {
                    finalDamage = (int) Math.floor(finalDamage * 1.25);
                } else {
                    finalDamage = (int) Math.ceil(finalDamage * 0.5);
                }
            }
        }

        return finalDamage;
    }
}
