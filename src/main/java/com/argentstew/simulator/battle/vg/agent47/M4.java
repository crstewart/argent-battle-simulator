package com.argentstew.simulator.battle.vg.agent47;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.agent47
 * 8/24/2019
 *
 * @author Craig
 */
public class M4 extends RangedAttack {

    private int ammo;

    public M4() {
        super();
        this.name = "M4 Assault Rifle";
        this.description = "90 ammo, each attack uses 30 ammo";
        this.power = 70;
        this.variance = 15;
        this.speed = 2;
        this.ammo = 90;
        this.subtypes = Collections.singletonList(AttackSubType.RIFLE);
        this.characteristics = Collections.singletonList(AttackCharacteristic.BULLET_SPEED);
    }

    @Override
    public DamageReport doAttack(Fighter defender) {
        ammo -= 30;
        return super.doAttack(defender);
    }

    @Override
    public boolean isDoable() {
        return ammo > 0;
    }
}
