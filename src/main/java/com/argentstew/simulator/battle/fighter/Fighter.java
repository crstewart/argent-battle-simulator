package com.argentstew.simulator.battle.fighter;

import com.argentstew.simulator.battle.action.Action;
import com.argentstew.simulator.battle.action.AttackAction;
import com.argentstew.simulator.battle.reporting.DamageReport;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

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

    public DamageReport attack() {
        AttackAction attack = selectAttackAction();
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

    private AttackAction selectAttackAction() {
        while (true) {
            int index = (int) Math.round(Math.random() * (actions.size() - 1));
            if (actions.get(index) instanceof AttackAction) {
                return (AttackAction) actions.get(index);
            }
        }
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
