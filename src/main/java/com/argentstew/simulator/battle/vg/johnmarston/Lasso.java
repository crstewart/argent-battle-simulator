package com.argentstew.simulator.battle.vg.johnmarston;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;
import com.argentstew.simulator.battle.action.attack.RangedAttack;
import com.argentstew.simulator.battle.fighter.Fighter;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.johnmarston
 * 8/27/2019
 *
 * @author Craig
 */
public class Lasso extends RangedAttack {

    public Lasso() {
        super();
        this.name = "Lasso";
        this.description = "Always ties up and stuns the opponent";
        this.power = 10;
        this.variance = 2;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.GRAPPLE);
        this.characteristics = Collections.singletonList(AttackCharacteristic.UNGUARDABLE);
    }

    @Override
    protected double getStunChance(Fighter defender, boolean isCrit) {
        return 1;
    }
}
