package com.argentstew.simulator.battle.vg.albertwesker;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;
import com.argentstew.simulator.battle.fighter.Fighter;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.albertwesker
 * 8/24/2019
 *
 * @author Craig
 */
public class CobraStrike extends MeleeAttack {

    public CobraStrike() {
        super();
        this.name = "Cobra Strike";
        this.description = "Has double critical hit chance";
        this.power = 40;
        this.variance = 5;
        this.speed = 0.5;
        this.subtypes = Collections.singletonList(AttackSubType.PUNCH);
        this.characteristics = Collections.emptyList();
    }

    @Override
    public double getStunChance(Fighter defender, boolean isCrit) {
        return super.getStunChance(defender, isCrit) * 2;
    }
}
