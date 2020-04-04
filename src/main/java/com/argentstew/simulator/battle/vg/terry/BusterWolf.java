package com.argentstew.simulator.battle.vg.terry;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.terry
 * 8/24/2019
 *
 * @author Craig
 */
public class BusterWolf extends MeleeAttack {

    public BusterWolf() {
        super();
        this.name = "Buster Wolf";
        this.power = 75;
        this.variance = 8;
        this.speed = 2.5;
        this.subtypes = Collections.singletonList(AttackSubType.PUNCH);
        this.characteristics = Collections.emptyList();
    }

    @Override
    public boolean isDoable() {
        return owner.getHp() <= (owner.getMaxHp() / 3);
    }
}
