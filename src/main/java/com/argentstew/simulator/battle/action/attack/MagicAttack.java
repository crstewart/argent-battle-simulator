package com.argentstew.simulator.battle.action.attack;

import com.argentstew.simulator.battle.action.AttackAction;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * com.argentstew.simulator.battle.action.attack
 * 8/24/2019
 *
 * @author Craig
 */
@Data
@EqualsAndHashCode(callSuper = false)
public abstract class MagicAttack extends AttackAction {

    private boolean requiresMeleeRange;

    protected MagicAttack() {
        super();
        this.attackType = AttackType.MAGIC;
    }

    @Override
    public double getSpeed() {
        if (requiresMeleeRange) {
            int distance = (int) Math.round(owner.getArena().getDistanceBetweenFighters());
            return 1 + (2 * (distance - 1)) + this.speed;
        }

        return this.speed;
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

    protected double getMissChance(Fighter defender) {
        return (0.015 * (11 - owner.getStats().getIntellect())) + (0.005 * (11 - defender.getStats().getSize()));
    }

    protected double getBaseDamage(Fighter defender) {
        return (power * 0.25) + (owner.getStats().getIntellect() * 0.5);
    }

    protected double getCritChance(Fighter defender) {
        return 0.04 + (owner.getStats().getWillpower() * 0.008);
    }

    protected double getCritMultiplier(Fighter defender) {
        return 2;
    }

    protected double getStunChance(Fighter defender, boolean isCrit) {
        double stunChance = ((11 - defender.getStats().getWillpower()) * 0.022);
        if (isCrit) {
            stunChance *= 1.3;
        }

        return stunChance;
    }
}
