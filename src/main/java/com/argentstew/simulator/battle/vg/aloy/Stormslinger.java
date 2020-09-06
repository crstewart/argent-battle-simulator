package com.argentstew.simulator.battle.vg.aloy;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.aloy
 * 8/24/2019
 *
 * @author Craig
 */
public class Stormslinger extends RangedAttack {

    private int ammo = 60;

    public Stormslinger() {
        super();
        this.name = "Stormslinger";
        this.description = "60 ammo, each attack uses 20 ammo";
        this.power = 60;
        this.variance = 6;
        this.speed = 1;
        this.subtypes = Arrays.asList(AttackSubType.EXPLOSIVE, AttackSubType.THUNDER);
        this.characteristics = Collections.emptyList();
    }

    @Override
    public DamageReport doAttack(Fighter defender) {
        ammo -= 20;
        return super.doAttack(defender);
    }

    @Override
    public boolean isDoable() {
        return ammo > 0;
    }
}
