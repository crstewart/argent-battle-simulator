package com.argentstew.simulator.battle.action.attack;

import com.argentstew.simulator.battle.action.AttackAction;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;
import lombok.EqualsAndHashCode;

/**
 * com.argentstew.simulator.battle.action.attack
 * 8/24/2019
 *
 * @author Craig
 */
@EqualsAndHashCode(callSuper = true)
public abstract class XStrike extends AttackAction {

    private static final int X_STRIKE_METER_READY = 20;

    @Override
    public DamageReport doAttack(Fighter defender) {
        owner.adjustXStrikeMeter(-1 * X_STRIKE_METER_READY);

        DamageReport report = new DamageReport();
        report.setAttack(this);

        double missChance = getMissChance(defender);
        if (Math.random() < missChance) {
            report.setMiss(true);
            return report;
        }

        double baseDamage = getBaseDamage(defender);
        double bonusDamage = Math.random() * variance;
        double damage = baseDamage + bonusDamage;
        damage *= defender.getDefenses().get(this.attackType);
        for (AttackSubType subType : this.subtypes) {
            damage *= defender.getDefenses().get(subType);
        }

        double critChance = getCritChance(defender);
        if (Math.random() < critChance) {
            report.setCrit(true);
            damage *= getCritMultiplier(defender);
        }

        int finalDamage = (int) Math.round(damage);
        report.setDamage(finalDamage);

        double stunChance = getStunChance(defender, report.isCrit());
        if (Math.random() < stunChance) {
            report.setStun(true);
        }

        return report;
    }

    protected abstract double getMissChance(Fighter defender);

    protected abstract double getBaseDamage(Fighter defender);

    protected abstract double getCritChance(Fighter defender);

    protected abstract double getCritMultiplier(Fighter defender);

    protected abstract double getStunChance(Fighter defender, boolean isCrit);

    @Override
    public double getStrategyAdjustment(DamageReport report) {
        return 0;
    }

    @Override
    public boolean isDoable() {
        return owner.getXStrikeMeter() >= X_STRIKE_METER_READY;
    }
}
