package com.argentstew.simulator.battle.fighter;

import com.argentstew.simulator.battle.action.Action;
import com.argentstew.simulator.battle.action.AttackAction;
import com.argentstew.simulator.battle.reporting.DamageReport;
import com.argentstew.simulator.battle.strategy.Strategy;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * com.argentstew.simulator.battle.fighter
 * 8/17/2019
 *
 * @author Craig
 */
@Data
@Builder
@AllArgsConstructor
public class Fighter {

    private String name;
    private int hp;
    private int maxHp;

    private List<Action> actions;

    private FighterDefenses defenses;
    private FighterStats stats;
    private FighterTraits traits;
    private Strategy strategy;

    public Fighter addAction(Action action) {
        if (actions == null) {
            actions = new ArrayList<>();
        }

        if (strategy != null) {
            strategy.addAction(action, 1.0);
        }

        action.setOwner(this);
        actions.add(action);
        return this;
    }

    public Fighter addActions(Iterable<Action> actions) {
        for (Action action : actions) {
           addAction(action);
        }

        return this;
    }

    public Action selectAction() {
        List<Action> doableActions = new ArrayList<>();
        for (Action action : actions) {
            if (action.isDoable()) {
                doableActions.add(action);
            }
        }

        return strategy.selectAction(doableActions);
    }

    public DamageReport attack() {
        AttackAction attack = (AttackAction) selectAction();
        double baseDamage = calculateBaseDamage(attack);
        DamageReport report = new DamageReport();
        report.setAttack(attack);
        if (Math.random() < 0.2) {
            report.setDamage((int) Math.round(baseDamage * 2));
            report.setCrit(true);
        } else {
            report.setDamage((int) Math.round(baseDamage));
            report.setCrit(false);
        }

        return report;
    }

    public void takeDamage(DamageReport report) {
        this.hp = (report.getDamage() > this.hp) ? 0 : this.hp - report.getDamage();
    }

    private double calculateBaseDamage(AttackAction attack) {
        int baseAttack = attack.getPower();
        double bonusDamage = Math.random() * attack.getVariance();
        return baseAttack + bonusDamage;
    }

    @Override
    public String toString() {
        return name + " (" + hp + "/" + maxHp + ")";
    }
}
