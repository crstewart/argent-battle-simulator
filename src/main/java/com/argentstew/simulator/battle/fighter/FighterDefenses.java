package com.argentstew.simulator.battle.fighter;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.AttackType;

import java.util.HashMap;
import java.util.Map;

/**
 * com.argentstew.simulator.battle.fighter
 * 8/19/2019
 *
 * @author Craig
 */
public class FighterDefenses {

    private Map<AttackType, Double> typeMultipliers;
    private Map<AttackSubType, Double> subtypeMultipliers;

    public FighterDefenses() {
        typeMultipliers = new HashMap<>(AttackType.values().length);
        for (AttackType attackType : AttackType.values()) {
            typeMultipliers.put(attackType, 1.0);
        }

        subtypeMultipliers = new HashMap<>(AttackSubType.values().length);
        for (AttackSubType subtype : AttackSubType.values()) {
            subtypeMultipliers.put(subtype, 1.0);
        }
    }

    public FighterDefenses set(AttackType attackType, double multiplier) {
        typeMultipliers.put(attackType, multiplier);
        return this;
    }

    public FighterDefenses set(AttackSubType subtype, double multiplier) {
        subtypeMultipliers.put(subtype, multiplier);
        return this;
    }

    public double get(AttackType attackType) {
        return typeMultipliers.get(attackType);
    }

    public double get(AttackSubType subtype) {
        return subtypeMultipliers.get(subtype);
    }
}
