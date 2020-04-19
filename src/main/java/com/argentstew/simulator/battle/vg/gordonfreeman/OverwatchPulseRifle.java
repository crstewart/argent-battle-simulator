package com.argentstew.simulator.battle.vg.gordonfreeman;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.gordonfreeman
 * 8/24/2019
 *
 * @author Craig
 */
public class OverwatchPulseRifle extends RangedAttack {

    private int ammo;

    public OverwatchPulseRifle() {
        super();
        this.name = "Overwatch Pulse Rifle";
        this.description = "60 ammo, each attack uses 30 ammo";
        this.power = 60;
        this.variance = 12;
        this.speed = 2;
        this.ammo = 60;
        this.subtypes = Collections.singletonList(AttackSubType.PLASMA);
        this.characteristics = Collections.singletonList(AttackCharacteristic.BULLET_SPEED);
    }

    @Override
    public DamageReport doAttack(Fighter defender) {
        ammo -= 30;
        return super.doAttack(defender);
    }

    @Override
    public boolean isDoable() {
        return ammo > 0;
    }
}
