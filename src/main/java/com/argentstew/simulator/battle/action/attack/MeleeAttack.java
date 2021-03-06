package com.argentstew.simulator.battle.action.attack;

import com.argentstew.simulator.battle.action.AttackAction;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;
import com.argentstew.simulator.battle.trait.Trait;
import com.argentstew.simulator.battle.trait.impl.StealthDetection;
import lombok.EqualsAndHashCode;

/**
 * com.argentstew.simulator.battle.action.attack
 * 8/24/2019
 *
 * @author Craig
 */
@EqualsAndHashCode(callSuper = true)
public abstract class MeleeAttack extends AttackAction {

    protected MeleeAttack() {
        super();
        this.requiresMeleeRange = true;
        this.attackType = AttackType.MELEE;
    }

    @Override
    public DamageReport doAttack(Fighter defender) {
        DamageReport report = new DamageReport();
        report.setAttack(this);
        report.setDefender(defender);

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
        for (Trait trait : owner.getTraits().getTraits()) {
            damage = trait.applyBonusDamage(defender, damage);
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
        if (defender.isStealth() && !owner.getTraits().has(new StealthDetection())) {
            return (defender.getStats().getSpeed() * 0.0325 + defender.getStats().getAgility() * 0.0575 +
                    ((10 - defender.getStats().getSize()) * 0.005));
        }

        return ((0.004 * Math.pow(owner.getStats().getDexterity() - 10, 2)) + 0.025)
                + (0.002 * (11 - defender.getStats().getSize()));
    }

    protected double getBaseDamage() {
        return (power * 0.2) + (owner.getStats().getStrength() * 0.4);
    }

    protected double getCritChance(Fighter defender) {
        return 0.04 + (owner.getStats().getAgility() * 0.008);
    }

    protected double getCritMultiplier(Fighter defender) {
        return 2;
    }

    protected double getStunChance(Fighter defender, boolean isCrit) {
        double stunChance = ((-0.03 * Math.pow(defender.getStats().getToughness(), 1.05)) + 0.4);
        if (isCrit) {
            stunChance *= 1.3;
        }

        return stunChance;
    }

    @Override
    public double calculateSpeed() {
        int distance = (int) Math.round(owner.getArena().getDistanceBetweenFighters());
        return 1 + (2 * (distance - 1)) + this.speed;
    }

    @Override
    public double getStrategyAdjustment(DamageReport report) {
        double expectedDamage = getBaseDamage() + (variance / 2.0);
        for (Trait trait : owner.getTraits().getTraits()) {
            expectedDamage = trait.applyBonusDamage(report.getDefender(), expectedDamage);
        }
        if (report.isCrit()) {
            expectedDamage *= getCritMultiplier(null);
        }

        double damageDifference = report.getDamage() - expectedDamage;
        return owner.getStats().getIntellect() * damageDifference * 0.02;
    }

    @Override
    public double getFailureAdjustment() {
        return owner.getStats().getIntellect() * -0.05;
    }
}
