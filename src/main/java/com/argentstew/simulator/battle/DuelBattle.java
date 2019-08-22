package com.argentstew.simulator.battle;

import com.argentstew.simulator.battle.action.Action;
import com.argentstew.simulator.battle.action.AttackAction;
import com.argentstew.simulator.battle.action.DefenseAction;
import com.argentstew.simulator.battle.action.MoveAction;
import com.argentstew.simulator.battle.calculator.DamageCalculator;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;
import lombok.AllArgsConstructor;

/**
 * com.argentstew.simulator.battle
 * 8/21/2019
 *
 * @author Craig
 */
@AllArgsConstructor
public class DuelBattle implements Battle {

    private Fighter fighter1;
    private Fighter fighter2;
    private DamageCalculator damageCalculator;

    @Override
    public void announce() {
        System.out.println(fighter1 + " enters!");
        System.out.println(fighter2 + " enters!");
        System.out.println("FIGHT!");
    }

    @Override
    public void start() {
        while (fighter1.getHp() > 0 && fighter2.getHp() > 0) {
            Action fighter1Action = fighter1.selectAction();
            Action fighter2Action = fighter2.selectAction();
            if (fighter1Action instanceof AttackAction && fighter2Action instanceof AttackAction) {
                resolveAttacks((AttackAction) fighter1Action, (AttackAction) fighter2Action);
            } else if (fighter1Action instanceof DefenseAction && fighter2Action instanceof AttackAction) {
                resolveDefense((AttackAction) fighter2Action, (DefenseAction) fighter1Action);
            } else if (fighter1Action instanceof AttackAction && fighter2Action instanceof DefenseAction) {
                resolveDefense((AttackAction) fighter1Action, (DefenseAction) fighter2Action);
            } else if (fighter1Action instanceof MoveAction && fighter2Action instanceof AttackAction) {
                resolveAttack((AttackAction) fighter2Action, (MoveAction) fighter1Action);
            } else if (fighter1Action instanceof AttackAction && fighter2Action instanceof MoveAction) {
                resolveAttack((AttackAction) fighter1Action, (MoveAction) fighter2Action);
            } else {
                resolveActions(fighter1Action, fighter2Action);
            }
        }
    }

    private void resolveAttacks(AttackAction fighter1Action, AttackAction fighter2Action) {
        if (fighter1Action.getSpeed() > fighter2Action.getSpeed()) {
            DamageReport report = damageCalculator.calculateDamage(fighter1Action, fighter2);
            System.out.println(fighter1.getName() + " attacks " + fighter2.getName() + " with " + report.getAttack().getName() + " for " + report.getDamage() + " damage!");
            if (report.isCrit()) {
                System.out.println("CRITICAL HIT!");
            }
            fighter2.takeDamage(report.getDamage());
            System.out.println(fighter2);
            if (fighter2.getHp() > 0) {
                if (report.isStun()) {
                    System.out.println(fighter2.getName() + " is stunned by the attack and cannot act!");
                } else {
                    report = damageCalculator.calculateDamage(fighter2Action, fighter1);
                    System.out.println(fighter2.getName() + " attacks " + fighter1.getName() + " with " + report.getAttack().getName() + " for " + report.getDamage() + " damage!");
                    if (report.isCrit()) {
                        System.out.println("CRITICAL HIT!");
                    }
                    fighter1.takeDamage(report.getDamage());
                    System.out.println(fighter1);
                }
            }
        } else if (fighter2Action.getSpeed() > fighter1Action.getSpeed()) {
            DamageReport report = damageCalculator.calculateDamage(fighter2Action, fighter1);
            System.out.println(fighter2.getName() + " attacks " + fighter1.getName() + " with " + report.getAttack().getName() + " for " + report.getDamage() + " damage!");
            if (report.isCrit()) {
                System.out.println("CRITICAL HIT!");
            }
            fighter1.takeDamage(report.getDamage());
            System.out.println(fighter1);
            if (fighter1.getHp() > 0) {
                if (report.isStun()) {
                    System.out.println(fighter1.getName() + " is stunned by the attack and cannot act!");
                } else {
                    report = damageCalculator.calculateDamage(fighter1Action, fighter2);
                    System.out.println(fighter1.getName() + " attacks " + fighter2.getName() + " with " + report.getAttack().getName() + " for " + report.getDamage() + " damage!");
                    if (report.isCrit()) {
                        System.out.println("CRITICAL HIT!");
                    }
                    fighter2.takeDamage(report.getDamage());
                    System.out.println(fighter2);
                }
            }
        } else {
            DamageReport report = damageCalculator.calculateDamage(fighter1Action, fighter2);
            System.out.println(fighter1.getName() + " attacks " + fighter2.getName() + " with " + report.getAttack().getName() + " for " + report.getDamage() + " damage!");
            if (report.isCrit()) {
                System.out.println("CRITICAL HIT!");
            }
            fighter2.takeDamage(report.getDamage());
            System.out.println(fighter2);

            report = damageCalculator.calculateDamage(fighter2Action, fighter1);
            System.out.println(fighter2.getName() + " attacks " + fighter1.getName() + " with " + report.getAttack().getName() + " for " + report.getDamage() + " damage!");
            if (report.isCrit()) {
                System.out.println("CRITICAL HIT!");
            }
            fighter1.takeDamage(report.getDamage());
            System.out.println(fighter1);
        }
    }

    private void resolveDefense(AttackAction attackAction, DefenseAction defenseAction) {

    }

    private void resolveAttack(AttackAction attackAction, MoveAction moveAction) {

    }

    private void resolveActions(Action action1, Action action2) {

    }

    @Override
    public void determineWinner() {
        if (fighter1.getHp() > 0) {
            System.out.println(fighter1.getName() + " wins!");
        } else if (fighter2.getHp() > 0) {
            System.out.println(fighter2.getName() + " wins!");
        } else {
            System.out.println(fighter1.getName() + " and " + fighter2.getName() + " fight to a draw!");
        }
    }
}
