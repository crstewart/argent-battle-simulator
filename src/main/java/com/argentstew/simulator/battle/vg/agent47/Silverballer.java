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
public class Silverballer extends RangedAttack {

    private int ammo;

    public Silverballer() {
        super();
        this.name = "Silverballer";
        this.description = "9 ammo, each attack uses 3 ammo";
        this.power = 85;
        this.variance = 7;
        this.speed = 1.5;
        this.ammo = 9;
        this.subtypes = Collections.singletonList(AttackSubType.HANDGUN);
        this.characteristics = Collections.singletonList(AttackCharacteristic.BULLET_SPEED);
    }

    @Override
    public DamageReport doAttack(Fighter defender) {
        ammo -= 3;
        return super.doAttack(defender);
    }

    @Override
    public boolean isDoable() {
        return ammo > 0;
    }
}
