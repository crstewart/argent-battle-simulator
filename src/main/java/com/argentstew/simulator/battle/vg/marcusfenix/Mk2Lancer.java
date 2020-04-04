package com.argentstew.simulator.battle.vg.marcusfenix;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.marcusfenix
 * 8/24/2019
 *
 * @author Craig
 */
public class Mk2Lancer extends RangedAttack {

    private int ammo;

    public Mk2Lancer() {
        super();
        this.name = "Mark 2 Lancer Assault Rifle";
        this.power = 70;
        this.variance = 12;
        this.speed = 1.5;
        this.ammo = 300;
        this.subtypes = Collections.singletonList(AttackSubType.RIFLE);
        this.characteristics = Collections.singletonList(AttackCharacteristic.BULLET_SPEED);
    }

    @Override
    public DamageReport doAttack(Fighter defender) {
        ammo -= 100;
        return super.doAttack(defender);
    }

    @Override
    public boolean isDoable() {
        return ammo > 0;
    }
}
