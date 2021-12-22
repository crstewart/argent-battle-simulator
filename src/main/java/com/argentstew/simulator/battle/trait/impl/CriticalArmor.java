package com.argentstew.simulator.battle.trait.impl;

import com.argentstew.simulator.battle.reporting.DamageReport;
import com.argentstew.simulator.battle.trait.AbstractArmorTrait;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * com.argentstew.simulator.battle.trait.impl
 * 3/27/2020
 *
 * @author argen
 */
@Getter
@EqualsAndHashCode(callSuper = true)
public class CriticalArmor extends AbstractArmorTrait {

    private final String name = "Critical Armor";
    private final String description = "The fighter receives 25% reduced damage from critical hits.";

    @Override
    protected int recalculateDamage(DamageReport report) {
        return report.isCrit() ? (int) Math.round(report.getDamage() * 0.75) : report.getDamage();
    }
}
