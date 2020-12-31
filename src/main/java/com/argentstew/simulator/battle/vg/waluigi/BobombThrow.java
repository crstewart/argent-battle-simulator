package com.argentstew.simulator.battle.vg.waluigi;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.waluigi
 * 8/27/2019
 *
 * @author Craig
 */
public class BobombThrow extends RangedAttack {

    private int ammo;

    public BobombThrow() {
        super();
        this.name = "Bob-omb Throw";
        this.description = "Only usable once";
        this.power = 90;
        this.variance = 9;
        this.speed = 3;
        this.ammo = 1;
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
