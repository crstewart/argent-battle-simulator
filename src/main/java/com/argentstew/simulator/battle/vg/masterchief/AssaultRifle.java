package com.argentstew.simulator.battle.vg.masterchief;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.masterchief
 * 8/24/2019
 *
 * @author Craig
 */
public class AssaultRifle extends RangedAttack {

    private int ammo;

    public AssaultRifle() {
        super();
        this.name = "Assault Rifle";
        this.description = "96 ammo, each attack uses 32 ammo";
        this.power = 75;
        this.variance = 20;
        this.speed = 2;
        this.ammo = 96;
        this.subtypes = Collections.singletonList(AttackSubType.RIFLE);
        this.characteristics = Collections.singletonList(AttackCharacteristic.BULLET_SPEED);
    }

    @Override
    public DamageReport doAttack(Fighter defender) {
        ammo -= 32;
        return super.doAttack(defender);
    }

    @Override
    public boolean isDoable() {
        return ammo > 0;
    }
}
