package com.argentstew.simulator.battle.trait;

import com.argentstew.simulator.battle.action.AttackAction;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;

/**
 * com.argentstew.simulator.battle.trait
 * 8/18/2019
 *
 * @author Craig
 */
public interface Trait {

    String getName();

    default double applyBonusDamage(Fighter defender, double rawDamage) {
        return rawDamage;
    }

    default AttackAction applyPassiveDefense(AttackAction attack) {
        return null;
    }

    default DamageReport applyArmor(DamageReport report) {
        return report;
    }
}
