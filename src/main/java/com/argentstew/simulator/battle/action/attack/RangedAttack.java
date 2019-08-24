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
public abstract class RangedAttack extends AttackAction {

    protected RangedAttack() {
        super();
        this.attackType = AttackType.RANGED;
    }

    @Override
    public DamageReport doAttack(Fighter defender) {
        DamageReport report = new DamageReport();
        report.setAttack(this);

        double missChance = getMissChance(defender);
        if (Math.random() < missChance) {
            report.setMiss(true);
            return report;
        }

        double baseDamage = getBaseDamage();
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

    protected double getMissChance(Fighter defender) {
        return (0.041 * (10 - owner.getStats().getAim())) + (0.009 * (11 - defender.getStats().getSize()));
    }

    protected double getBaseDamage() {
        return (power * 0.2) + (owner.getStats().getDexterity() * 0.4);
    }

    protected double getCritChance(Fighter defender) {
        return 0.04 + (owner.getStats().getAgility() * 0.003) + (owner.getStats().getAim() * 0.005);
    }

    protected double getCritMultiplier(Fighter defender) {
        return 2;
    }

    protected double getStunChance(Fighter defender, boolean isCrit) {
        double stunChance = ((11 - defender.getStats().getToughness()) * 0.022);
        if (isCrit) {
            stunChance *= 1.3;
        }

        return stunChance;
    }

    @Override
    public double calculateSpeed() {
        return this.speed;
    }

    @Override
    public double getStrategyAdjustment(DamageReport report) {
        double expectedDamage = getBaseDamage() + (variance / 2.0);
        if (report.isCrit()) {
            expectedDamage *= getCritMultiplier(null);
        }

        double damageDifference = report.getDamage() - expectedDamage;
        return owner.getStats().getIntellect() * damageDifference * 0.05;
    }

    @Override
    public double getFailureAdjustment() {
        return owner.getStats().getIntellect() * -0.05;
    }
}
