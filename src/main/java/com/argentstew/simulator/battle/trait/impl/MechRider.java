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
public class MechRider extends AbstractArmorTrait {

    private final String name = "Mech Rider";
    private final String description = "The fighter receives 20% reduced damage from attacks but 25% additional " +
            "damage from critical hits.";

    @Override
    protected int recalculateDamage(DamageReport report) {
        return report.isCrit()
                ? (int) Math.round(report.getDamage() * 1.25)
                : (int) Math.round(report.getDamage() * 0.8);
    }

    @Override
    public boolean isImmuneToTorment() {
        return true;
    }
}
