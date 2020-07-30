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
public class M3Predator extends RangedAttack {

    private int ammo;

    public M3Predator() {
        super();
        this.name = "M-3 Predator (Cryo)";
        this.description = "12 ammo, each attack uses 4 shots";
        this.power = 100;
        this.variance = 7;
        this.speed = 1.5;
        this.ammo = 12;
        this.subtypes = Arrays.asList(AttackSubType.RIFLE, AttackSubType.ICE);
        this.characteristics = Collections.singletonList(AttackCharacteristic.BULLET_SPEED);
    }

    @Override
    public DamageReport doAttack(Fighter defender) {
        ammo -= 4;
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
