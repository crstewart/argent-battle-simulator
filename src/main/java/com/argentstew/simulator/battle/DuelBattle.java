package com.argentstew.simulator.battle;

import com.argentstew.simulator.battle.action.Action;
import com.argentstew.simulator.battle.action.AttackAction;
import com.argentstew.simulator.battle.action.DefenseAction;
import com.argentstew.simulator.battle.action.MoveAction;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.logger.BattleLogger;
import com.argentstew.simulator.battle.reporting.DamageReport;
import com.argentstew.simulator.battle.trait.Trait;
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
    private BattleLogger battleLogger;

    @Override
    public void announce() {
        battleLogger.log("Today's battle: " + fighter1.getName() + " vs. " + fighter2.getName() + "!");
        battleLogger.log(fighter1.getEntryQuote());
        battleLogger.log(fighter2.getEntryQuote());
        battleLogger.log("FIGHT!");
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

            battleLogger.log("Status: " + fighter1 + " vs " + fighter2);
        }
    }

    private void resolveAttacks(AttackAction fighter1Action, AttackAction fighter2Action) {
        if (fighter1Action.calculateSpeed() < fighter2Action.calculateSpeed()) {
            DamageReport report = resolveAttackAgainstFighter(fighter1Action, fighter2);
            if (fighter2.getHp() > 0) {
                if (report.isStun()) {
                    battleLogger.log(fighter2.getName() + " is stunned by the attack and cannot act!");
                    fighter2.getStrategy().adjustWeight(fighter2Action, fighter2Action.getFailureAdjustment());
                } else {
                    resolveAttackAgainstFighter(fighter2Action, fighter1);
                }
            }
        } else if (fighter2Action.calculateSpeed() < fighter1Action.calculateSpeed()) {
            DamageReport report = resolveAttackAgainstFighter(fighter2Action, fighter1);
            if (fighter1.getHp() > 0) {
                if (report.isStun()) {
                    battleLogger.log(fighter1.getName() + " is stunned by the attack and cannot act!");
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
        if (attack.calculateSpeed() < defense.calculateSpeed()) {
            resolveAttackAgainstFighter(attack, defense.getOwner());
            battleLogger.log(defense.getOwner().getName() + " failed to defend against the attack in time!");
            defense.getOwner().getStrategy().adjustWeight(defense, defense.getFailureAdjustment());
        } else {
            battleLogger.log(attack.getOwner().getName() + " attacks " + defense.getOwner().getName() + " with " + attack.getName() + "!");
            battleLogger.log(defense.getOwner().getName() + " " + defense.getInitiateMessage());
            if (defense.isSuccessful(attack)) {
                battleLogger.log(defense.getOwner().getName() + " " + defense.getSuccessMessage());
                DamageReport report = attack.doAttack(defense.getOwner());
                int damage = defense.applyDefense(report.getDamage());
                if (damage > 0) {
                    battleLogger.log(defense.getOwner().getName() + " takes " + report.getDamage() + " damage!");
                    defense.getOwner().takeDamage(damage);
                    battleLogger.log(defense.getOwner());
                }
                defense.getOwner().getStrategy().adjustWeight(defense, defense.getSuccessAdjustment());
                defense.getOwner().adjustXStrikeMeter((defense instanceof Dodge) ? 3 : 2);
                if (defense.getOwner().getHp() > 0) {
                    AttackAction counterAttack = defense.doCounterAttack(attack, damage);
                    if (counterAttack != null) {
                        resolveAttackAgainstFighter(counterAttack, attack.getOwner());
                    }
                }
                applyPassiveDefenses(attack, defense.getOwner());
            } else {
                battleLogger.log(defense.getOwner().getName() + " " + defense.getFailureMessage());
                resolveAttackAgainstFighter(attack, defense.getOwner());
                defense.getOwner().getStrategy().adjustWeight(defense, defense.getFailureAdjustment());
            }
        }
    }

    private void resolveAttack(AttackAction attack, MoveAction move) {
        if (attack.calculateSpeed() < move.calculateSpeed()) {
            DamageReport report = resolveAttackAgainstFighter(attack, move.getOwner());
            if (report.isStun()) {
                battleLogger.log(move.getOwner().getName() + " is stunned by the attack and cannot act!");
                move.getOwner().getStrategy().adjustWeight(move, move.getFailureAdjustment());
            } else {
                battleLogger.log(move.getOwner().getName() + " " + move.getMessage());
                move.move();
                move.getOwner().getStrategy().adjustWeight(move, move.getSuccessAdjustment());
            }
        } else {
            battleLogger.log(move.getOwner().getName() + " " + move.getMessage());
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
            battleLogger.log(defense.getOwner().getName() + " " + defense.getInitiateMessage());
        } else {
            MoveAction move = (MoveAction) action1;
            battleLogger.log(move.getOwner().getName() + " " + move.getMessage());
            move.move();
            move.getOwner().getStrategy().adjustWeight(move, move.getSuccessAdjustment());
        }

        if (action2 instanceof DefenseAction) {
            DefenseAction defense = (DefenseAction) action2;
            battleLogger.log(defense.getOwner().getName() + " " + defense.getInitiateMessage());
        } else {
            MoveAction move = (MoveAction) action2;
            battleLogger.log(move.getOwner().getName() + " " + move.getMessage());
            move.move();
            move.getOwner().getStrategy().adjustWeight(move, move.getSuccessAdjustment());
        }
    }

    private DamageReport resolveAttackAgainstFighter(AttackAction attack, Fighter fighter) {
        battleLogger.log(attack.getOwner().getName() + " attacks " + fighter.getName() + " with " + attack.getName() + "!");
        DamageReport report = attack.doAttack(fighter);
        if (report.isMiss()) {
            battleLogger.log(attack.getOwner().getName() + " missed!");
            attack.getOwner().getStrategy().adjustWeight(attack, attack.getFailureAdjustment());
        } else {
            battleLogger.log(fighter.getName() + " takes " + report.getDamage() + " damage!");
            double strategyAdjustment = attack.getStrategyAdjustment(report);
            attack.getOwner().getStrategy().adjustWeight(attack, strategyAdjustment);
            attack.getOwner().adjustXStrikeMeter(1);
        }
        if (report.isCrit()) {
            battleLogger.log("CRITICAL HIT!");
        }

        fighter.takeDamage(report.getDamage());
        battleLogger.log(fighter);

        applyPassiveDefenses(attack, fighter);

        return report;
    }

    private void applyPassiveDefenses(AttackAction attack, Fighter defender) {
        for (Trait trait : defender.getTraits().getTraits()) {
            AttackAction counterAttack = trait.applyPassiveDefense(attack);
            if (counterAttack != null) {
                DamageReport counterReport = counterAttack.doAttack(attack.getOwner());
                battleLogger.log(defender.getName() + "'s " + counterReport.getAttack().getName() + " counters for " + counterReport.getDamage() + " damage!");
                attack.getOwner().takeDamage(counterReport.getDamage());
                battleLogger.log(attack.getOwner());
            }
        }
    }

    @Override
    public Fighter determineWinner() {
        if (fighter1.getHp() > 0) {
            battleLogger.log(fighter1.getName() + " wins!");
            battleLogger.log(fighter1.getVictoryQuote());
            return fighter1;
        } else if (fighter2.getHp() > 0) {
            battleLogger.log(fighter2.getName() + " wins!");
            battleLogger.log(fighter2.getVictoryQuote());
            return fighter2;
        } else {
            battleLogger.log(fighter1.getName() + " and " + fighter2.getName() + " fight to a draw!");
            return null;
        }
    }
}
