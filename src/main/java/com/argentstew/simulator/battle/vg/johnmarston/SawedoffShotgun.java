package com.argentstew.simulator.battle.vg.johnmarston;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.johnmarston
 * 8/27/2019
 *
 * @author Craig
 */
public class SawedoffShotgun extends RangedAttack {

    private int ammo;

    public SawedoffShotgun() {
        super();
        this.name = "Sawed-Off Shotgun";
        this.description = "2 ammo";
        this.power = 85;
        this.variance = 8;
        this.speed = 2;
        this.ammo = 2;
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
