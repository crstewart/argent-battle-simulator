package com.argentstew.simulator.battle.vg.ellie;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.ellie
 * 8/24/2019
 *
 * @author Craig
 */
public class PumpShotgun extends RangedAttack {

    private int ammo;

    public PumpShotgun() {
        super();
        this.name = "Pump Shotgun";
        this.description = "4 ammo";
        this.power = 100;
        this.variance = 10;
        this.speed = 3;
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
    public boolean isAllowed() {
        return ammo > 0;
    }
}
