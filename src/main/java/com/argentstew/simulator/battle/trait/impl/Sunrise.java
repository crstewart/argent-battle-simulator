package com.argentstew.simulator.battle.trait.impl;

import com.argentstew.simulator.battle.action.Action;
import com.argentstew.simulator.battle.action.AttackAction;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.fighter.Fighter;
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
public class Sunrise extends AbstractArmorTrait {

    private final String name = "Sunrise";
    private final String description = "The fighter receives 20% reduced damage from characters who have a " +
            "dark-elemental attack.";

    @Override
    protected int recalculateDamage(DamageReport report) {
        Fighter attacker = report.getAttack().getOwner();
        for (Action action : attacker.getActions()) {
            if (action instanceof AttackAction) {
                AttackAction attack = (AttackAction) action;
                if (attack.getSubtypes().contains(AttackSubType.DARK)) {
                    return (int) Math.ceil(report.getDamage() * 0.8);
                }
            }
        }

        return report.getDamage();
    }
}
