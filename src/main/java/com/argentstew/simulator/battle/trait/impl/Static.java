package com.argentstew.simulator.battle.trait.impl;

import com.argentstew.simulator.battle.action.AttackAction;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;
import com.argentstew.simulator.battle.status.StatusEffect;
import com.argentstew.simulator.battle.status.StatusType;
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
public class Static implements Trait {

    private final String name = "Static";

    @Override
    public AttackAction applyPassiveDefense(AttackAction attack) {
        if (attack instanceof MeleeAttack) {
            return new StaticElectricity();
        }

        return null;
    }

    public static class StaticElectricity extends AttackAction {

        private StaticElectricity() {
            super();
            this.name = "Static Electricity";
        }

        @Override
        public DamageReport doAttack(Fighter defender) {
            double hitChance = Math.random();
            if (hitChance < 0.3) {
                defender.setStatus(new StatusEffect(StatusType.PARALYSIS));
            }

            DamageReport report = new DamageReport();
            report.setAttack(this);
            report.setMiss(hitChance < 0.3);
            report.setStun(false);
            report.setCrit(false);
            report.setDamage(0);
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
