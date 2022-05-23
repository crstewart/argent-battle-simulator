package com.argentstew.simulator.battle.vg.charizard;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.charizard
 * 9/8/2019
 *
 * @author Craig
 */
public class SeismicToss extends MeleeAttack {

    public SeismicToss() {
        super();
        this.name = "Seismic Toss";
        this.description = "Priority reduced by opponent weight, damage increased by opponent strength";
        this.power = 30;
        this.variance = 5;
        this.speed = 0.5;
        this.subtypes = Arrays.asList(AttackSubType.GRAPPLE, AttackSubType.SLAM);
        this.characteristics = Collections.singletonList(AttackCharacteristic.HOLD);
    }

    @Override
    public double calculateSpeed() {
        return super.calculateSpeed() + ((10 - owner.getArena().getOpponent(owner).getStats().getWeight()) * 0.5);
    }

    @Override
    public DamageReport doAttack(Fighter defender) {
        this.power = 50 + (int) ((10 - owner.getArena().getOpponent(owner).getStats().getStrength()) * 0.5);
        return super.doAttack(defender);
    }
}
