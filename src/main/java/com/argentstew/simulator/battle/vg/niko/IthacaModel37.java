package com.argentstew.simulator.battle.vg.niko;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.niko
 * 8/27/2019
 *
 * @author Craig
 */
public class IthacaModel37 extends RangedAttack {

    private int ammo;

    public IthacaModel37() {
        super();
        this.name = "Ithaca Model 37";
        this.description = "8 ammo";
        this.power = 75;
        this.variance = 7;
        this.speed = 3;
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
