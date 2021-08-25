package com.argentstew.simulator.battle.trait.impl;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.reporting.DamageReport;
import com.argentstew.simulator.battle.trait.AbstractArmorTrait;
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
@EqualsAndHashCode(callSuper = true)
public class BarrierChange extends AbstractArmorTrait {

    private static final List<AttackSubType> ELEMENTS = Collections.unmodifiableList(Arrays.asList(
            AttackSubType.FIRE, AttackSubType.ICE, AttackSubType.THUNDER, AttackSubType.DARK)
    );

    private final String name = "Barrier Change";
    private AttackSubType lastElementUsed;

    public BarrierChange() {
        this.lastElementUsed = ELEMENTS.get((int) Math.floor(Math.random() * ELEMENTS.size()));
    }

    public void setLastElementUsed(AttackSubType lastElementUsed) {
        this.lastElementUsed = lastElementUsed;
    }

    @Override
    protected int recalculateDamage(DamageReport report) {
        int finalDamage = report.getDamage();
        for (AttackSubType subType : report.getAttack().getSubtypes()) {
            if (ELEMENTS.contains(subType)) {
                if (subType.equals(lastElementUsed)) {
                    finalDamage = (int) Math.floor(finalDamage * 2);
                } else {
                    finalDamage = (int) Math.ceil(finalDamage * 0.5);
                }
            }
        }

        return finalDamage;
    }
}
