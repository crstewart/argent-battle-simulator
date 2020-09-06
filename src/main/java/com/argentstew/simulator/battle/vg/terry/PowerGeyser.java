package com.argentstew.simulator.battle.vg.terry;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.terry
 * 8/24/2019
 *
 * @author Craig
 */
public class PowerGeyser extends MeleeAttack {

    public PowerGeyser() {
        super();
        this.name = "Power Geyser";
        this.description = "Requires HP to be at 1/3 or less";
        this.power = 140;
        this.variance = 10;
        this.speed = 2.5;
        this.subtypes = Collections.singletonList(AttackSubType.CHI);
        this.characteristics = Collections.emptyList();
    }

    @Override
    public boolean isDoable() {
        return owner.getHp() <= (owner.getMaxHp() / 3);
    }
}
