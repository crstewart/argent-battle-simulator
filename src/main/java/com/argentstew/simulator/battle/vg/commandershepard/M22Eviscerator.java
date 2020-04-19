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
public class M22Eviscerator extends RangedAttack {

    private int ammo;

    public M22Eviscerator() {
        super();
        this.name = "M-22 Eviscerator (Incendiary)";
        this.description = "3 ammo";
        this.power = 100;
        this.variance = 10;
        this.speed = 2;
        this.ammo = 3;
        this.subtypes = Arrays.asList(AttackSubType.SHOTGUN, AttackSubType.FIRE);
        this.characteristics = Collections.singletonList(AttackCharacteristic.BULLET_SPEED);
    }

    @Override
    public DamageReport doAttack(Fighter defender) {
        ammo -= 1;
        return super.doAttack(defender);
    }

    @Override
    protected double getStunChance(Fighter defender, boolean isCrit) {
        return super.getStunChance(defender, isCrit) * 1.5;
    }

    @Override
    public boolean isDoable() {
        return ammo > 0;
    }
}
