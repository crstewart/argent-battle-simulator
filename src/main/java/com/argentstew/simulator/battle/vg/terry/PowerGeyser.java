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
        this.power = 80;
        this.variance = 7;
        this.speed = 2.5;
        this.subtypes = Collections.singletonList(AttackSubType.CHI);
        this.characteristics = Collections.emptyList();
    }

    @Override
    public boolean isDoable() {
        return owner.getHp() <= (owner.getMaxHp() / 3);
    }
}
