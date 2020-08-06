package com.argentstew.simulator.battle.vg.heavy;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.heavy
 * 8/24/2019
 *
 * @author Craig
 */
public class Minigun extends RangedAttack {

    private int ammo;

    public Minigun() {
        super();
        this.name = "Minigun";
        this.description = "200 ammo, each attack uses 50 ammo";
        this.power = 60;
        this.variance = 20;
        this.speed = 3.5;
        this.ammo = 200;
        this.subtypes = Collections.singletonList(AttackSubType.RIFLE);
        this.characteristics = Collections.singletonList(AttackCharacteristic.BULLET_SPEED);
    }

    @Override
    public DamageReport doAttack(Fighter defender) {
        ammo -= 50;
        return super.doAttack(defender);
    }

    @Override
    public boolean isDoable() {
        return ammo > 0;
    }
}
