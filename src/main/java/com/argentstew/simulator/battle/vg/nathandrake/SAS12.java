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
public class SAS12 extends RangedAttack {

    private int ammo;

    public SAS12() {
        super();
        this.name = "SAS-12";
        this.description = "8 ammo";
        this.power = 75;
        this.variance = 10;
        this.speed = 2;
        this.ammo = 8;
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
