package com.argentstew.simulator.battle;

import com.argentstew.simulator.battle.action.Action;
import com.argentstew.simulator.battle.action.AttackAction;
import com.argentstew.simulator.battle.action.DefenseAction;
import com.argentstew.simulator.battle.action.MoveAction;
import com.argentstew.simulator.battle.action.defense.Dodge;
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

    @Override
    public void announce() {
        System.out.println(fighter1.getEntryQuote());
        System.out.println(fighter2.getEntryQuote());
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

            fighter1.adjustXStrikeMeter(1);
            fighter2.adjustXStrikeMeter(1);
        }
    }

    private void resolveAttacks(AttackAction fighter1Action, AttackAction fighter2Action) {
        if (fighter1Action.getSpeed() > fighter2Action.getSpeed()) {
            DamageReport report = resolveAttackAgainstFighter(fighter1Action, fighter2);
            if (fighter2.getHp() > 0) {
                if (report.isStun()) {
                    System.out.println(fighter2.getName() + " is stunned by the attack and cannot act!");
                    fighter2.getStrategy().adjustWeight(fighter2Action, fighter2Action.getFailureAdjustment());
                } else {
                    resolveAttackAgainstFighter(fighter2Action, fighter1);
                }
            }
        } else if (fighter2Action.getSpeed() > fighter1Action.getSpeed()) {
            DamageReport report = resolveAttackAgainstFighter(fighter2Action, fighter1);
            if (fighter1.getHp() > 0) {
                if (report.isStun()) {
                    System.out.println(fighter1.getName() + " is stunned by the attack and cannot act!");
                    fighter1.getStrategy().adjustWeight(fighter1Action, fighter1Action.getFailureAdjustment());
                } else {
                    resolveAttackAgainstFighter(fighter1Action, fighter2);
                }
            }
        } else {
            resolveAttackAgainstFighter(fighter1Action, fighter2);
            resolveAttackAgainstFighter(fighter2Action, fighter1);
        }
    }

    private void resolveDefense(AttackAction attack, DefenseAction defense) {
        if (attack.getSpeed() > defense.getSpeed()) {
            resolveAttackAgainstFighter(attack, defense.getOwner());
            System.out.println(defense.getOwner().getName() + " failed to defend against the attack in time!");
            defense.getOwner().getStrategy().adjustWeight(defense, defense.getFailureAdjustment());
        } else {
            System.out.println(attack.getOwner().getName() + " attacks " + defense.getOwner().getName() + " with " + attack.getName() + "!");
            System.out.println(defense.getOwner().getName() + " " + defense.getInitiateMessage());
            if (defense.isSuccessful(attack)) {
                System.out.println(defense.getOwner().getName() + " " + defense.getSuccessMessage());
                DamageReport report = attack.doAttack(defense.getOwner());
                int damage = defense.applyDefense(report.getDamage());
                if (damage > 0) {
                    System.out.println(defense.getOwner().getName() + " takes " + report.getDamage() + " damage!");
                    defense.getOwner().takeDamage(damage);
                }
                defense.getOwner().getStrategy().adjustWeight(defense, defense.getSuccessAdjustment());
                defense.getOwner().adjustXStrikeMeter((defense instanceof Dodge) ? 2 : 1);
                if (defense.getOwner().getHp() > 0) {
                    AttackAction counterAttack = defense.doCounterAttack(attack, damage);
                    if (counterAttack != null) {
                        resolveAttackAgainstFighter(counterAttack, attack.getOwner());
                    }
                }
            } else {
                System.out.println(defense.getOwner().getName() + " " + defense.getFailureMessage());
                resolveAttackAgainstFighter(attack, defense.getOwner());
                defense.getOwner().getStrategy().adjustWeight(defense, defense.getFailureAdjustment());
            }
        }
    }

    private void resolveAttack(AttackAction attack, MoveAction move) {
        if (attack.getSpeed() > move.getSpeed()) {
            DamageReport report = resolveAttackAgainstFighter(attack, move.getOwner());
            if (report.isStun()) {
                System.out.println(move.getOwner().getName() + " is stunned by the attack and cannot act!");
                move.getOwner().getStrategy().adjustWeight(move, move.getFailureAdjustment());
            } else {
                System.out.println(move.getOwner().getName() + " " + move.getMessage());
                move.move();
                move.getOwner().getStrategy().adjustWeight(move, move.getSuccessAdjustment());
            }
        } else {
            System.out.println(move.getOwner().getName() + " " + move.getMessage());
            move.move();
            DamageReport report = resolveAttackAgainstFighter(attack, move.getOwner());
            if (report.isMiss()) {
                move.getOwner().getStrategy().adjustWeight(move, move.getFailureAdjustment());
            } else {
                move.getOwner().getStrategy().adjustWeight(move, move.getSuccessAdjustment());
            }
        }
    }

    private void resolveActions(Action action1, Action action2) {
        if (action1 instanceof DefenseAction) {
            DefenseAction defense = (DefenseAction) action1;
            System.out.println(defense.getOwner().getName() + " " + defense.getInitiateMessage());
        } else {
            MoveAction move = (MoveAction) action1;
            System.out.println(move.getOwner().getName() + " " + move.getMessage());
            move.move();
            move.getOwner().getStrategy().adjustWeight(move, move.getSuccessAdjustment());
        }

        if (action2 instanceof DefenseAction) {
            DefenseAction defense = (DefenseAction) action2;
            System.out.println(defense.getOwner().getName() + " " + defense.getInitiateMessage());
        } else {
            MoveAction move = (MoveAction) action2;
            System.out.println(move.getOwner().getName() + " " + move.getMessage());
            move.move();
            move.getOwner().getStrategy().adjustWeight(move, move.getSuccessAdjustment());
        }
    }

    private DamageReport resolveAttackAgainstFighter(AttackAction attack, Fighter fighter) {
        System.out.println(attack.getOwner().getName() + " attacks " + fighter.getName() + " with " + attack.getName() + "!");
        DamageReport report = attack.doAttack(fighter);
        if (report.isMiss()) {
            System.out.println(attack.getOwner().getName() + " missed!");
            attack.getOwner().getStrategy().adjustWeight(attack, attack.getFailureAdjustment());
        } else {
            System.out.println(fighter.getName() + " takes " + report.getDamage() + " damage!");
            double strategyAdjustment = attack.getStrategyAdjustment(report);
            attack.getOwner().getStrategy().adjustWeight(attack, strategyAdjustment);
            attack.getOwner().adjustXStrikeMeter(1);
        }
        if (report.isCrit()) {
            System.out.println("CRITICAL HIT!");
        }

        fighter.takeDamage(report.getDamage());
        System.out.println(fighter);

        return report;
    }

    @Override
    public void determineWinner() {
        if (fighter1.getHp() > 0) {
            System.out.println(fighter1.getName() + " wins!");
            System.out.println(fighter1.getVictoryQuote());
        } else if (fighter2.getHp() > 0) {
            System.out.println(fighter2.getName() + " wins!");
            System.out.println(fighter2.getVictoryQuote());
        } else {
            System.out.println(fighter1.getName() + " and " + fighter2.getName() + " fight to a draw!");
        }
    }
}
