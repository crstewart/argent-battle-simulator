package com.argentstew.simulator.battle.trait.impl;

import com.argentstew.simulator.battle.action.AttackAction;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;
import com.argentstew.simulator.battle.trait.Trait;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * com.argentstew.simulator.battle.trait
 * 8/23/2019
 *
 * @author Craig
 */
@Getter
@EqualsAndHashCode
public class Righteousness implements Trait {

    private final String name = "Righteousness";
    private final String description = "The fighter does light-elemental counterattack damage to melee attackers.";

    @Override
    public AttackAction applyPassiveDefense(AttackAction attack) {
        if (attack.isRequiresMeleeRange()) {
            return new RighteousLight();
        }

        return null;
    }

    public static class RighteousLight extends AttackAction {

        private RighteousLight() {
            super();
            this.name = "Righteous Light";
        }

        @Override
        public DamageReport doAttack(Fighter defender) {
            DamageReport report = new DamageReport();
            report.setAttack(this);
            report.setMiss(false);
            report.setStun(false);
            report.setCrit(false);

            double damage = Math.round(3 + (Math.random() * 3));
            damage *= defender.getDefenses().get(AttackSubType.LIGHT);
            report.setDamage((int) damage);

            return report;
        }

        @Override
        public double getStrategyAdjustment(DamageReport report) {
            return 0;
        }

        @Override
        public double getFailureAdjustment() {
            return 0;
        }
    }
}
