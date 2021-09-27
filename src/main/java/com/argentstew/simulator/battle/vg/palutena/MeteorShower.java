package com.argentstew.simulator.battle.vg.palutena;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.palutena
 * 8/27/2019
 *
 * @author Craig
 */
public class MeteorShower extends RangedAttack {

    private static final int EQUIP_COST = 7;

    private boolean used = false;

    public MeteorShower() {
        super();
        this.name = "Meteor Shower";
        this.power = 40;
        this.variance = 6;
        this.speed = 1.5;
        this.subtypes = Collections.singletonList(AttackSubType.EARTH);
        this.characteristics = Collections.singletonList(AttackCharacteristic.UNDODGEABLE);
    }

    @Override
    public DamageReport doAttack(Fighter defender) {
        if (!used) {
            used = true;
            owner.restoreMagic(EQUIP_COST);
        }

        return super.doAttack(defender);
    }

    @Override
    public boolean isAllowed() {
        return used || owner.getMp() + EQUIP_COST <= owner.getMaxMp();
    }
}
