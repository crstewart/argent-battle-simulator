package com.argentstew.simulator.battle.vg.vyse;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MagicAttack;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.vyse
 * 8/24/2019
 *
 * @author Craig
 */
public class RainOfSwords extends MagicAttack {

    public static final int MP_COST = 14;

    public RainOfSwords() {
        super();
        this.name = "Rain of Swords";
        this.description = "Uses 14 SP";
        this.power = 80;
        this.variance = 8;
        this.speed = 3;
        this.subtypes = Collections.singletonList(AttackSubType.THUNDER);
        this.characteristics = Collections.singletonList(AttackCharacteristic.UNDODGEABLE);
    }

    @Override
    public DamageReport doAttack(Fighter defender) {
        owner.useMagic(MP_COST);
        return super.doAttack(defender);
    }

    @Override
    public boolean isDoable() {
        return owner.getMp() >= MP_COST;
    }
}
