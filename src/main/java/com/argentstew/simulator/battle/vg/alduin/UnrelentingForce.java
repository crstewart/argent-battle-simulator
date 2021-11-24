package com.argentstew.simulator.battle.vg.alduin;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.fighter.FighterStats;
import com.argentstew.simulator.battle.reporting.DamageReport;
import com.argentstew.simulator.battle.trait.Trait;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.alduin
 * 8/27/2019
 *
 * @author Craig
 */
public class UnrelentingForce extends RangedAttack {

    public UnrelentingForce() {
        super();
        this.name = "Unrelenting Force (Fus Ro Dah)";
        this.description = "Deals additional damage based on the opponent's weight";
        this.power = 10;
        this.variance = 4;
        this.speed = 2;
        this.subtypes = Collections.singletonList(AttackSubType.AIR);
        this.characteristics = Collections.singletonList(AttackCharacteristic.UNGUARDABLE);
    }

    @Override
    public DamageReport doAttack(Fighter defender) {
        DamageReport report = super.doAttack(defender);
        if (report.getDamage() > 0) {
            report.setDamage(report.getDamage() + (2 * (int) Math.round(defender.getStat(FighterStats.WEIGHT))));
            owner.getArena().fullRetreat(defender);
        }

        return report;
    }

    @Override
    public double getStrategyAdjustment(DamageReport report) {
        double expectedDamage = getBaseDamage() + (variance / 2.0) + 5;
        for (Trait trait : owner.getTraits()) {
            expectedDamage = trait.applyBonusDamage(report.getDefender(), expectedDamage);
        }
        if (report.isCrit()) {
            expectedDamage *= getCritMultiplier(null);
        }

        double damageDifference = report.getDamage() - expectedDamage;
        return owner.getStat(FighterStats.INTELLECT) * damageDifference * 0.05;
    }
}
