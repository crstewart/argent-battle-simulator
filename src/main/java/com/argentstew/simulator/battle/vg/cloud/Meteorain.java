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
public class Meteorain extends RangedAttack {

    public Meteorain() {
        super();
        this.name = "Meteorain";
        this.description = "Gains 2 SP";
        this.power = 70;
        this.variance = 5;
        this.speed = 2;
        this.subtypes = Collections.singletonList(AttackSubType.EARTH);
        this.characteristics = Collections.singletonList(AttackCharacteristic.UNDODGEABLE);
    }

    @Override
    public DamageReport doAttack(Fighter defender) {
        int mp = this.owner.getMp();
        this.owner.setMp(Math.min(mp + 2, this.owner.getMaxMp()));
        return super.doAttack(defender);
    }

    @Override
    public boolean isDoable() {
        return this.owner.getMp() < this.owner.getMaxMp();
    }
}
