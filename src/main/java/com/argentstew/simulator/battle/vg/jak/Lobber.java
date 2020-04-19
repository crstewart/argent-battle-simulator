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
public class Lobber extends RangedAttack {

    private int ammo;

    public Lobber() {
        super();
        this.name = "Lobber";
        this.description = "3 ammo";
        this.power = 80;
        this.variance = 7;
        this.speed = 2;
        this.ammo = 3;
        this.subtypes = Arrays.asList(AttackSubType.EXPLOSIVE, AttackSubType.NATURE);
        this.characteristics = Collections.emptyList();
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
