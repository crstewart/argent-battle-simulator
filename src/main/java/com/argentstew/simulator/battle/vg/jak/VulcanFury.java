package com.argentstew.simulator.battle.vg.jak;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.jak
 * 8/24/2019
 *
 * @author Craig
 */
public class VulcanFury extends RangedAttack {

    private int ammo;

    public VulcanFury() {
        super();
        this.name = "Vulcan Fury";
        this.power = 70;
        this.variance = 6;
        this.speed = 2;
        this.ammo = 10;
        this.subtypes = Arrays.asList(AttackSubType.RIFLE, AttackSubType.THUNDER);
        this.characteristics = Collections.singletonList(AttackCharacteristic.BULLET_SPEED);
    }

    @Override
    public DamageReport doAttack(Fighter defender) {
        ammo -= 1;
        return super.doAttack(defender);
    }

    @Override
    public boolean isDoable() {
        return ammo > 0;
    }
}
