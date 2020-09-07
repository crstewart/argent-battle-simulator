package com.argentstew.simulator.battle.vg.samfisher;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.samfisher
 * 8/24/2019
 *
 * @author Craig
 */
public class FiveSeven extends RangedAttack {

    private int ammo;

    public FiveSeven() {
        super();
        this.name = "Five-seven";
        this.description = "20 ammo, each attack uses 5 ammo";
        this.power = 80;
        this.variance = 8;
        this.speed = 1.5;
        this.ammo = 20;
        this.subtypes = Collections.singletonList(AttackSubType.HANDGUN);
        this.characteristics = Collections.singletonList(AttackCharacteristic.BULLET_SPEED);
    }

    @Override
    public DamageReport doAttack(Fighter defender) {
        ammo -= 5;
        return super.doAttack(defender);
    }

    @Override
    public boolean isDoable() {
        return ammo > 0;
    }
}
