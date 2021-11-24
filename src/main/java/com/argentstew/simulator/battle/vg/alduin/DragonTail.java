package com.argentstew.simulator.battle.vg.alduin;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;
import com.argentstew.simulator.battle.fighter.Fighter;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.alduin
 * 8/27/2019
 *
 * @author Craig
 */
public class DragonTail extends MeleeAttack {

    public DragonTail() {
        super();
        this.name = "Dragon Tail";
        this.description = "Has a 50% increased chance to stun";
        this.power = 40;
        this.variance = 3;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.TAIL);
        this.characteristics = Collections.emptyList();
    }

    @Override
    protected double getStunChance(Fighter defender, boolean isCrit) {
        return super.getStunChance(defender, isCrit) * 1.5;
    }
}
