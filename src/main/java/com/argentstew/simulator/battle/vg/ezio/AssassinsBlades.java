package com.argentstew.simulator.battle.vg.ezio;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeXStrike;
import com.argentstew.simulator.battle.fighter.Fighter;

import java.util.Arrays;

/**
 * com.argentstew.simulator.battle.vg.ezio
 * 8/27/2019
 *
 * @author Craig
 */
public class AssassinsBlades extends MeleeXStrike {

    public AssassinsBlades() {
        super();
        this.name = "Assassin's Blades";
        this.power = 150;
        this.variance = 10;
        this.speed = 1;
        this.subtypes = Arrays.asList(AttackSubType.PIERCE, AttackSubType.TOXIC);
        this.characteristics = Arrays.asList(AttackCharacteristic.UNGUARDABLE, AttackCharacteristic.UNDODGEABLE);
    }

    @Override
    public double getCritChance(Fighter defender) {
        return 0.5;
    }
}
