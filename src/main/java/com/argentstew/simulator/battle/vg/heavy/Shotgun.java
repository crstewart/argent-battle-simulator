package com.argentstew.simulator.battle.vg.heavy;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.heavy
 * 8/24/2019
 *
 * @author Craig
 */
public class Shotgun extends RangedAttack {

    private int ammo;

    public Shotgun() {
        super();
        this.name = "Shotgun";
        this.description = "6 ammo";
        this.power = 70;
        this.variance = 7;
        this.speed = 1.5;
        this.ammo = 6;
        this.subtypes = Collections.singletonList(AttackSubType.SHOTGUN);
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
