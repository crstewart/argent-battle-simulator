package com.argentstew.simulator.battle.vg.snake;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;
import com.argentstew.simulator.battle.fighter.Fighter;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.snake
 * 8/27/2019
 *
 * @author Craig
 */
public class StunKnife extends MeleeAttack {

    public StunKnife() {
        super();
        this.name = "Stun Knife";
        this.description = "Has half normal stun chance if the enemy resists thunder, double stun chance if weak to thunder";
        this.power = 50;
        this.variance = 5;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.SLASH);
        this.characteristics = Collections.emptyList();
    }

    @Override
    protected double getStunChance(Fighter defender, boolean isCrit) {
        if (defender.getDefenses().get(AttackSubType.THUNDER) < 1) {
            return super.getStunChance(defender, isCrit) / 2;
        }

        return super.getStunChance(defender, isCrit) * 2;
    }
}
