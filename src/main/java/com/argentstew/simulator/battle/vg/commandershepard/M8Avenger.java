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
public class M8Avenger extends RangedAttack {

    private int ammo;

    public M8Avenger() {
        super();
        this.name = "M-8 Avenger (Armor-piercing)";
        this.power = 50;
        this.variance = 12;
        this.speed = 1;
        this.ammo = 400;
        this.subtypes = Arrays.asList(AttackSubType.RIFLE, AttackSubType.ARMOR_PIERCING);
        this.characteristics = Collections.singletonList(AttackCharacteristic.BULLET_SPEED);
    }

    @Override
    public DamageReport doAttack(Fighter defender) {
        ammo -= 40;
        return super.doAttack(defender);
    }

    @Override
    public boolean isDoable() {
        return ammo > 0;
    }
}
