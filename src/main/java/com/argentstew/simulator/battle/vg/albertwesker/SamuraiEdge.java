package com.argentstew.simulator.battle.vg.albertwesker;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.albertwesker
 * 8/24/2019
 *
 * @author Craig
 */
public class SamuraiEdge extends RangedAttack {

    private int ammo;

    public SamuraiEdge() {
        super();
        this.name = "Samurai Edge";
        this.description = "10 ammo";
        this.power = 80;
        this.variance = 6;
        this.speed = 1;
        this.ammo = 10;
        this.subtypes = Collections.singletonList(AttackSubType.HANDGUN);
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
