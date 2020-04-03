package com.argentstew.simulator.battle.vg.nathandrake;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.nathandrake
 * 8/24/2019
 *
 * @author Craig
 */
public class AK47 extends RangedAttack {

    private int ammo;

    public AK47() {
        super();
        this.name = "AK-47";
        this.power = 70;
        this.variance = 9;
        this.speed = 1.5;
        this.ammo = 90;
        this.subtypes = Collections.singletonList(AttackSubType.RIFLE);
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
