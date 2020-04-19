package com.argentstew.simulator.battle.vg.snake;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
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
public class FAMAS extends RangedAttack {

    private int ammo;

    public FAMAS() {
        super();
        this.name = "FAMAS G1";
        this.description = "100 ammo, each attack uses 25 ammo";
        this.power = 55;
        this.variance = 8;
        this.speed = 2;
        this.ammo = 100;
        this.subtypes = Collections.singletonList(AttackSubType.RIFLE);
        this.characteristics = Collections.singletonList(AttackCharacteristic.BULLET_SPEED);
    }

    @Override
    public DamageReport doAttack(Fighter defender) {
        ammo -= 25;
        return super.doAttack(defender);
    }

    @Override
    public boolean isDoable() {
        return ammo > 0;
    }
}
