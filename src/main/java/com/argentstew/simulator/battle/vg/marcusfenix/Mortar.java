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
public class Mortar extends RangedAttack {

    private int ammo;

    public Mortar() {
        super();
        this.name = "Mortar";
        this.description = "12 ammo";
        this.power = 70;
        this.variance = 7;
        this.speed = 2;
        this.ammo = 12;
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
