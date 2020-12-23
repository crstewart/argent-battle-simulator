package com.argentstew.simulator.battle;

import com.argentstew.simulator.battle.action.Action;
import com.argentstew.simulator.battle.action.AttackAction;
import com.argentstew.simulator.battle.action.DefenseAction;
import com.argentstew.simulator.battle.action.MoveAction;
import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.XStrike;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.defense.Heal;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
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

    private final Fighter fighter1;
    private final Fighter fighter2;
    private final BattleLogger battleLogger;

    @Override
    public void announce() {
        battleLogger.log("Today's battle: " + fighter1.getName() + " vs. " + fighter2.getName() + "!");
        battleLogger.log(fighter1.getEntryQuote());
        battleLogger.log(fighter2.getEntryQuote());
        battleLogger.log("FIGHT!");
    }

    @Override
    public void start() {
        int turn = 1;
        while (fighter1.getHp() > 0 && fighter2.getHp() > 0) {
            if (turn >= 100) {
                fighter1.setHp(0);
                fighter2.setHp(0);
                continue;
            }
            battleLogger.log("----- Turn " + turn + " -----");
            Action fighter1Action = fighter1.selectAction();
            Action fighter2Action = fighter2.selectAction();
            resolveStealth(fighter1Action, fighter2Action);
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

            fighter1.setStealth(false);
            fighter2.setStealth(false);

            fighter1.adjustXStrikeMeter(1);
            fighter2.adjustXStrikeMeter(1);

            battleLogger.log("Status: " + fighter1 + " vs " + fighter2);
            turn++;
        }
    }

    private void resolveStealth(Action fighter1Action, Action fighter2Action) {
        if (fighter1Action instanceof AttackAction) {
            AttackAction fighter1Attack = (AttackAction) fighter1Action;
            if (fighter1Attack.getCharacteristics().contains(AttackCharacteristic.STEALTH)) {
                fighter1Attack.getOwner().setStealth(true);
            }
        }

        if (fighter2Action instanceof AttackAction) {
            AttackAction fighter2Attack = (AttackAction) fighter2Action;
            if (fighter2Attack.getCharacteristics().contains(AttackCharacteristic.STEALTH)) {
                fighter2Attack.getOwner().setStealth(true);
            }
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
            DamageReport report = resolveAttackAgainstFighter(attack, defense.getOwner());
            int damage = report.getDamage();
            if (defense instanceof Heal && damage < defense.getOwner().getHp() && defense.isSuccessful(attack)) {
                battleLogger.log(defense.getOwner().getName() + " " + defense.getSuccessMessage());
                applyHeal((Heal) defense, damage);
                defense.getOwner().getStrategy().adjustWeight(defense, defense.getSuccessAdjustment());
            } else {
                battleLogger.log(defense.getOwner().getName() + " failed to defend against the attack!");
                defense.getOwner().getStrategy().adjustWeight(defense, defense.getFailureAdjustment());
            }
        } else {
            battleLogger.log(attack.getOwner().getName() + " readies their " + attack.getName() + " attack!");
            battleLogger.log(defense.getOwner().getName() + " " + defense.getInitiateMessage());
            if (defense.isSuccessful(attack)) {
                battleLogger.log(defense.getOwner().getName() + " " + defense.getSuccessMessage());
                DamageReport report = attack.doAttack(defense.getOwner());
                for (Trait trait : defense.getOwner().getTraits().getTraits()) {
                    report = trait.applyArmor(report);
                }
                int damage = defense.applyDefense(report.getDamage());
                if (defense instanceof Heal && damage < defense.getOwner().getHp()) {
                    applyHeal((Heal) defense, damage);
                }
                if (damage > 0) {
                    battleLogger.log(defense.getOwner().getName() + " takes " + damage + " damage!");
                    defense.getOwner().takeDamage(damage);
                }
                battleLogger.log(defense.getOwner());
                defense.getOwner().getStrategy().adjustWeight(defense, defense.getSuccessAdjustment());
                if (defense instanceof Dodge) {
                    defense.getOwner().adjustXStrikeMeter(2);
                } else {
                    defense.getOwner().adjustXStrikeMeter(3);
                }
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
                if ((move instanceof Advance && move.getOwner().getArena().canAdvance(move.getOwner())) ||
                        (move instanceof Retreat && move.getOwner().getArena().canRetreat(move.getOwner()))) {
                    battleLogger.log(move.getOwner().getName() + " " + move.getMessage());
                    move.move();
                    move.getOwner().getStrategy().adjustWeight(move, move.getSuccessAdjustment());
                } else if (move instanceof Advance) {
                    battleLogger.log(move.getOwner().getName() + " can no longer advance!");
                    move.getOwner().getStrategy().adjustWeight(move, move.getFailureAdjustment());
                } else {
                    battleLogger.log(move.getOwner().getName() + " can no longer retreat!");
                    move.getOwner().getStrategy().adjustWeight(move, move.getFailureAdjustment());
                }
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
            if (defense instanceof Heal) {
                Heal heal = (Heal) defense;
                battleLogger.log(heal.getOwner().getName() + " " + heal.getSuccessMessage());
                applyHeal(heal, 0);
            }
        } else {
            MoveAction move = (MoveAction) action1;
            battleLogger.log(move.getOwner().getName() + " " + move.getMessage());
            move.move();
            move.getOwner().getStrategy().adjustWeight(move, move.getSuccessAdjustment());
        }

        if (action2 instanceof DefenseAction) {
            DefenseAction defense = (DefenseAction) action2;
            battleLogger.log(defense.getOwner().getName() + " " + defense.getInitiateMessage());
            if (defense instanceof Heal) {
                Heal heal = (Heal) defense;
                battleLogger.log(heal.getOwner().getName() + " " + heal.getSuccessMessage());
                applyHeal(heal, 0);
            }
        } else {
            MoveAction move = (MoveAction) action2;
            if ((move instanceof Advance && move.getOwner().getArena().canAdvance(move.getOwner()))
                    || move instanceof Retreat) {
                battleLogger.log(move.getOwner().getName() + " " + move.getMessage());
                move.move();
                move.getOwner().getStrategy().adjustWeight(move, move.getSuccessAdjustment());
            } else {
                battleLogger.log(move.getOwner().getName() + " can no longer advance!");
            }
        }
    }

    private DamageReport resolveAttackAgainstFighter(AttackAction attack, Fighter fighter) {
        if (attack instanceof XStrike) {
            battleLogger.log(attack.getOwner().getName() + " unleashes their X-STRIKE!");
        }
        battleLogger.log(attack.getOwner().getName() + " attacks " + fighter.getName() + " with " + attack.getName() + "!");
        DamageReport report = attack.doAttack(fighter);
        for (Trait trait : fighter.getTraits().getTraits()) {
            report = trait.applyArmor(report);
        }
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
                for (Trait armorTrait : defender.getTraits().getTraits()) {
                    counterReport = armorTrait.applyArmor(counterReport);
                }
                battleLogger.log(defender.getName() + "'s " + counterReport.getAttack().getName() + " counters for " + counterReport.getDamage() + " damage!");
                attack.getOwner().takeDamage(counterReport.getDamage());
                battleLogger.log(attack.getOwner());
            }
        }
    }

    private void applyHeal(Heal heal, int incomingDamage) {
        int hpRestored = heal.restoreHealth(incomingDamage);
        if (hpRestored > 0) {
            heal.getOwner().heal(hpRestored);
            battleLogger.log(heal.getOwner().getName() + " restores " + hpRestored + " health!");
            heal.getOwner().getStrategy().adjustWeight(heal, heal.getSuccessAdjustment());
            heal.getOwner().adjustXStrikeMeter(2);
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
