package com.argentstew.simulator.battle.vg.ellie;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.ellie
 * 8/24/2019
 *
 * @author Craig
 */
public class Pistol extends RangedAttack {

    private int ammo;

    public Pistol() {
        super();
        this.name = "Pistol";
        this.description = "18 ammo; each attack uses 6 ammo";
        this.power = 80;
        this.variance = 6;
        this.speed = 1.5;
        this.ammo = 18;
        this.subtypes = Collections.singletonList(AttackSubType.HANDGUN);
        this.characteristics = Collections.singletonList(AttackCharacteristic.BULLET_SPEED);
    }

    @Override
    public DamageReport doAttack(Fighter defender) {
        ammo -= 6;
        return super.doAttack(defender);
    }

    @Override
    public boolean isAllowed() {
        return ammo > 0;
    }
}
