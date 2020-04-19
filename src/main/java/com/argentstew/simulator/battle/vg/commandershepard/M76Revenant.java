package com.argentstew.simulator.battle.vg.commandershepard;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.commandershepard
 * 8/24/2019
 *
 * @author Craig
 */
public class M76Revenant extends RangedAttack {

    private int ammo;

    public M76Revenant() {
        super();
        this.name = "M-76 Revenant (Disruptor)";
        this.description = "240 ammo, each attack uses 80 ammo";
        this.power = 60;
        this.variance = 15;
        this.speed = 3;
        this.ammo = 240;
        this.subtypes = Arrays.asList(AttackSubType.RIFLE, AttackSubType.THUNDER);
        this.characteristics = Arrays.asList(AttackCharacteristic.BULLET_SPEED, AttackCharacteristic.UNGUARDABLE);
    }

    @Override
    public DamageReport doAttack(Fighter defender) {
        ammo -= 80;
        return super.doAttack(defender);
    }

    @Override
    public boolean isDoable() {
        return ammo > 0;
    }
}
