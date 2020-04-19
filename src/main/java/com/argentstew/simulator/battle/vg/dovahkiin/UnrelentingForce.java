package com.argentstew.simulator.battle.vg.dovahkiin;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;
import com.argentstew.simulator.battle.action.attack.RangedAttack;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;
import com.argentstew.simulator.battle.trait.Trait;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.dovahkiin
 * 8/27/2019
 *
 * @author Craig
 */
public class UnrelentingForce extends RangedAttack {

    public UnrelentingForce() {
        super();
        this.name = "Unrelenting Force (Fus Ro Dah)";
        this.description = "Deals additional damage based on the opponent's weight";
        this.power = 40;
        this.variance = 4;
        this.speed = 2;
        this.subtypes = Collections.singletonList(AttackSubType.AIR);
        this.characteristics = Collections.singletonList(AttackCharacteristic.UNGUARDABLE);
    }

    @Override
    public DamageReport doAttack(Fighter defender) {
        DamageReport report = super.doAttack(defender);
        if (report.getDamage() > 0) {
            report.setDamage(report.getDamage() + (int) Math.round(defender.getStats().getWeight()));
            owner.getArena().fullRetreat(defender);
        }

        return report;
    }

    @Override
    public double getStrategyAdjustment(DamageReport report) {
        double expectedDamage = getBaseDamage() + (variance / 2.0) + 5;
        for (Trait trait : owner.getTraits().getTraits()) {
            expectedDamage = trait.applyBonusDamage(report.getDefender(), expectedDamage);
        }
        if (report.isCrit()) {
            expectedDamage *= getCritMultiplier(null);
        }

        double damageDifference = report.getDamage() - expectedDamage;
        return owner.getStats().getIntellect() * damageDifference * 0.05;
    }
}
