package com.argentstew.simulator.battle.vg.jak;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.jak
 * 8/24/2019
 *
 * @author Craig
 */
public class ScatterGun extends RangedAttack {

    private int ammo;

    public ScatterGun() {
        super();
        this.name = "Scatter Gun";
        this.power = 60;
        this.variance = 8;
        this.speed = 1.5;
        this.ammo = 5;
        this.subtypes = Arrays.asList(AttackSubType.RIFLE, AttackSubType.FIRE);
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
