package com.argentstew.simulator.battle.vg.leonkennedy;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;
import com.argentstew.simulator.battle.action.attack.RangedAttack;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.ryu
 * 8/24/2019
 *
 * @author Craig
 */
public class W870Shotgun extends RangedAttack {

    private int ammo;

    public W870Shotgun() {
        super();
        this.name = "W-870 Shotgun";
        this.description = "4 ammo";
        this.power = 90;
        this.variance = 15;
        this.speed = 2.5;
        this.ammo = 4;
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
