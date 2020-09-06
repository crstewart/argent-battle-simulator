package com.argentstew.simulator.battle.vg.sweettooth;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;
import com.argentstew.simulator.battle.action.attack.RangedAttack;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.sweettooth
 * 8/24/2019
 *
 * @author Craig
 */
public class Shotgun extends RangedAttack {

    private int ammo;

    public Shotgun() {
        super();
        this.name = "Shotgun";
        this.description = "3 ammo";
        this.power = 100;
        this.variance = 10;
        this.speed = 2;
        this.ammo = 3;
        this.subtypes = Collections.singletonList(AttackSubType.SHOTGUN);
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
