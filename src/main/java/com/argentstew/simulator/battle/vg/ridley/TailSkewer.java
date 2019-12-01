package com.argentstew.simulator.battle.vg.ridley;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;
import com.argentstew.simulator.battle.fighter.Fighter;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.ridley
 * 9/15/2019
 *
 * @author Craig
 */
public class TailSkewer extends MeleeAttack {

    public TailSkewer() {
        super();
        this.name = "Tail Skewer";
        this.power = 45;
        this.variance = 4;
        this.speed = 1.5;
        this.subtypes = Collections.singletonList(AttackSubType.PIERCE);
        this.characteristics = Collections.emptyList();
    }

    @Override
    public double getCritChance(Fighter defender) {
        return 2 * super.getCritChance(defender);
    }
}
