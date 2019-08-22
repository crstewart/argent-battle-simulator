package com.argentstew.simulator.battle.calculator;

import com.argentstew.simulator.battle.action.AttackAction;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;

/**
 * com.argentstew.simulator.battle.calculator
 * 8/21/2019
 *
 * @author Craig
 */
public interface DamageCalculator {

    DamageReport calculateDamage(AttackAction attack, Fighter defender);
}
