package com.argentstew.simulator.battle.vg.nathandrake;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.nathandrake
 * 8/24/2019
 *
 * @author Craig
 */
public class MkNDIGrenade extends RangedAttack {

    private int ammo;

    public MkNDIGrenade() {
        super();
        this.name = "Mk-NDI Grenade";
        this.description = "3 ammo";
        this.power = 90;
        this.variance = 8;
        this.speed = 2.5;
        this.ammo = 3;
        this.subtypes = Collections.singletonList(AttackSubType.EXPLOSIVE);
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
