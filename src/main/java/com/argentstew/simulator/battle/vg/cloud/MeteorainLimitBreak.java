package com.argentstew.simulator.battle.vg.cloud;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.cloud
 * 8/24/2019
 *
 * @author Craig
 */
public class MeteorainLimitBreak extends RangedAttack {

    public MeteorainLimitBreak() {
        super();
        this.name = "Meteorain (Limit Break)";
        this.description = "Uses all SP";
        this.power = 140;
        this.variance = 10;
        this.speed = 1.5;
        this.subtypes = Collections.singletonList(AttackSubType.EARTH);
        this.characteristics = Collections.singletonList(AttackCharacteristic.UNDODGEABLE);
    }

    @Override
    public DamageReport doAttack(Fighter defender) {
        this.owner.setMp(0);
        return super.doAttack(defender);
    }

    @Override
    public boolean isDoable() {
        return this.owner.getMp() >= this.owner.getMaxMp();
    }
}
