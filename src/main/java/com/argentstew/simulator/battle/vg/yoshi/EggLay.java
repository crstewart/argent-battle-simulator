package com.argentstew.simulator.battle.vg.yoshi;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;
import com.argentstew.simulator.battle.fighter.Fighter;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.yoshi
 * 8/26/2019
 *
 * @author Craig
 */
public class EggLay extends MeleeAttack {

    public EggLay() {
        super();
        this.name = "Egg Lay";
        this.description = "Always stuns the opponent";
        this.power = 15;
        this.variance = 2;
        this.speed = 0.5;
        this.subtypes = Arrays.asList(AttackSubType.GRAPPLE, AttackSubType.BITE);
        this.characteristics = Collections.singletonList(AttackCharacteristic.UNGUARDABLE);
    }

    @Override
    public double getStunChance(Fighter defender, boolean isCrit) {
        return 1;
    }
}
