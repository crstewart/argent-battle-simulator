package com.argentstew.simulator.battle.trait.impl;

import com.argentstew.simulator.battle.action.Action;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.reporting.DamageReport;
import com.argentstew.simulator.battle.trait.AbstractArmorTrait;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * com.argentstew.simulator.battle.trait.impl
 * 8/24/2021
 *
 * @author argen
 */
@Getter
@EqualsAndHashCode(callSuper = true)
public class BuddySystem extends AbstractArmorTrait {

    private final String name = "Buddy System";
    private final String description = "When at 50% health or higher, the character gains 4 additional priority on " +
            "all moves and a 50% resistance to assist attacks.";

    @Override
    public double applyBonusPriority(Action action, double speed) {
        return (action.getOwner().getHp() > action.getOwner().getMaxHp() / 2) ? speed - 4 : speed;
    }

    @Override
    protected int recalculateDamage(DamageReport report) {
        if ((report.getDefender().getHp() > report.getDefender().getMaxHp() / 2)
                && report.getAttack().getSubtypes().contains(AttackSubType.ASSIST)) {
            return (int) Math.round(report.getDamage() * 0.5);
        }

        return report.getDamage();
    }

    @Override
    public boolean isImmuneToTorment() {
        return true;
    }
}
