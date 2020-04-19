package com.argentstew.simulator.battle.vg.scorpion;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;
import com.argentstew.simulator.battle.fighter.Fighter;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.scorpion
 * 8/27/2019
 *
 * @author Craig
 */
public class LegTakedown extends MeleeAttack {

    public LegTakedown() {
        super();
        this.name = "Leg Takedown";
        this.description = "Has 50% additional stun chance";
        this.power = 50;
        this.variance = 6;
        this.speed = 1.5;
        this.subtypes = Collections.singletonList(AttackSubType.KICK);
        this.characteristics = Collections.emptyList();
    }

    @Override
    public double getStunChance(Fighter defender, boolean isCrit) {
        return super.getStunChance(defender, isCrit) * 1.5;
    }
}
