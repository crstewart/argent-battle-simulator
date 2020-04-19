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
public class Blaster extends RangedAttack {

    private int ammo;

    public Blaster() {
        super();
        this.name = "Blaster";
        this.description = "10 ammo";
        this.power = 50;
        this.variance = 4;
        this.speed = 3;
        this.ammo = 10;
        this.subtypes = Arrays.asList(AttackSubType.RIFLE, AttackSubType.AIR);
        this.characteristics = Collections.singletonList(AttackCharacteristic.BULLET_SPEED);
    }

    @Override
    public DamageReport doAttack(Fighter defender) {
        ammo -= 1;
        return super.doAttack(defender);
    }

    @Override
    protected double getBaseDamage() {
        double baseDamage = super.getBaseDamage();
        double distanceBetweenFighters = owner.getArena().getDistanceBetweenFighters();
        return baseDamage * (distanceBetweenFighters / 2.0);
    }

    @Override
    public boolean isDoable() {
        return ammo > 0;
    }
}
