package com.argentstew.simulator.battle.vg.lloyd;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;
import com.argentstew.simulator.battle.action.attack.RangedAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.lloyd
 * 8/27/2019
 *
 * @author Craig
 */
public class DemonFang extends RangedAttack {

    public DemonFang() {
        super();
        this.name = "Demon Fang";
        this.power = 45;
        this.variance = 4;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.SLASH);
        this.characteristics = Collections.emptyList();
    }
}
