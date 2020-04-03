package com.argentstew.simulator.battle.vg.snake;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.snake
 * 8/24/2019
 *
 * @author Craig
 */
public class M67FragGrenade extends RangedAttack {

    private int ammo;

    public M67FragGrenade() {
        super();
        this.name = "M67 Fragmentation Grenade";
        this.power = 80;
        this.variance = 10;
        this.speed = 3;
        this.ammo = 3;
        this.subtypes = Collections.singletonList(AttackSubType.EXPLOSIVE);
        this.characteristics = Collections.emptyList();
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
