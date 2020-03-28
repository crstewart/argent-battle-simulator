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
 * com.argentstew.simulator.battle.trait
 * 8/23/2019
 *
 * @author Craig
 */
@Getter
@EqualsAndHashCode
public class Hazardous implements Trait {

    private static final List<AttackSubType> RETALIATION_TYPES = Collections.unmodifiableList(Arrays.asList(
            AttackSubType.PUNCH, AttackSubType.KICK, AttackSubType.HEADBUTT, AttackSubType.SLAM,
            AttackSubType.CLAW, AttackSubType.BITE, AttackSubType.TAIL
    ));

    private String name = "Hazardous";

    @Override
    public double applyBonusDamage(Fighter defender, double rawDamage) {
        return rawDamage;
    }

    @Override
    public AttackAction applyPassiveDefense(AttackAction attack) {
        for (AttackSubType subtype : attack.getSubtypes()) {
            if (RETALIATION_TYPES.contains(subtype)) {
                return new HazardousBody();
            }
        }

        return null;
    }

    @Override
    public DamageReport applyArmor(DamageReport report) {
        return report;
    }

    public static class HazardousBody extends AttackAction {

        private HazardousBody() {
            super();
            this.name = "Hazardous Body";
        }

        @Override
        public DamageReport doAttack(Fighter defender) {
            DamageReport report = new DamageReport();
            report.setAttack(this);
            report.setMiss(false);
            report.setStun(false);
            report.setCrit(false);
            report.setDamage((int) Math.round(1 + (Math.random() * 2)));
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
