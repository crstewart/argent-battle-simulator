package com.argentstew.simulator.battle.trait.impl;

import com.argentstew.simulator.battle.action.AttackAction;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.AttackType;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;
import com.argentstew.simulator.battle.strategy.Strategy;
import com.argentstew.simulator.battle.trait.AbstractArmorTrait;
import com.argentstew.simulator.battle.vg.illidan.Metamorphosis;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * com.argentstew.simulator.battle.trait
 * 8/23/2019
 *
 * @author Craig
 */
@Getter
@EqualsAndHashCode(callSuper = true, exclude = {"transformedUser"})
public class DemonicForm extends AbstractArmorTrait {

    public static final String DEMONIC_FORM_ENABLED_STATUS = "Demon Form";
    public static final String DEMONIC_FORM_DISABLED_STATUS = "Resting";

    private final String name = "Demonic Form";

    private Fighter transformedUser;
    private Strategy strategy;
    private int remainingTurns = 0;

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public AttackAction applyPassiveDefense(AttackAction attack) {
        return (transformedUser != null
                && DEMONIC_FORM_ENABLED_STATUS.equals(transformedUser.getSelfStatus())
                && attack.isRequiresMeleeRange()) ? new ImmolationAura() : null;
    }

    @Override
    protected int recalculateDamage(DamageReport report) {
        return (int) Math.round(report.getDamage() * 0.875);
    }

    @Override
    public void setUpTurn() {
        if (remainingTurns > 0) {
            remainingTurns--;
        } else {
            strategy.adjustWeight(new Metamorphosis(), 0.2);
        }

        if (remainingTurns <= 0 && transformedUser != null) {
            transformedUser.setSelfStatus(DEMONIC_FORM_DISABLED_STATUS);
            transformedUser = null;
        }
    }

    public void transform(Fighter owner) {
        remainingTurns = 6;
        transformedUser = owner;
        owner.setSelfStatus(DEMONIC_FORM_ENABLED_STATUS);
    }

    public static class ImmolationAura extends AttackAction {

        private ImmolationAura() {
            super();
            this.name = "Immolation Aura";
        }

        @Override
        public DamageReport doAttack(Fighter defender) {
            DamageReport report = new DamageReport();
            report.setAttack(this);
            report.setMiss(false);
            report.setStun(false);
            report.setCrit(false);

            double damage = 2 + (Math.random() * 3);
            damage *= defender.getDefenses().get(AttackType.MAGIC);
            damage *= defender.getDefenses().get(AttackSubType.DARK);
            damage *= defender.getDefenses().get(AttackSubType.FIRE);
            report.setDamage((int) Math.round(damage));

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
