package com.argentstew.simulator.battle.vg.fox;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.fox
 * 8/24/2019
 *
 * @author Craig
 */
public class GatlingGun extends RangedAttack {

    private int ammo;

    public GatlingGun() {
        super();
        this.name = "Gatling Gun";
        this.description = "3 ammo";
        this.power = 75;
        this.variance = 10;
        this.speed = 1.5;
        this.ammo = 3;
        this.subtypes = Arrays.asList(AttackSubType.RIFLE, AttackSubType.ARMOR_PIERCING);
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
