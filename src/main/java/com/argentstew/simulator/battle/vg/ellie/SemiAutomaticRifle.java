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
public class SemiAutomaticRifle extends RangedAttack {

    private int ammo;

    public SemiAutomaticRifle() {
        super();
        this.name = "Semi-automatic Rifle";
        this.description = "18 ammo; each attack uses 9 ammo";
        this.power = 60;
        this.variance = 15;
        this.speed = 2;
        this.ammo = 18;
        this.subtypes = Collections.singletonList(AttackSubType.RIFLE);
        this.characteristics = Collections.singletonList(AttackCharacteristic.BULLET_SPEED);
    }

    @Override
    public DamageReport doAttack(Fighter defender) {
        ammo -= 9;
        return super.doAttack(defender);
    }

    @Override
    public boolean isAllowed() {
        return ammo > 0;
    }
}
