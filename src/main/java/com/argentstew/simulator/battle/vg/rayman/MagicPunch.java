package com.argentstew.simulator.battle.vg.rayman;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.rayman
 * 8/24/2019
 *
 * @author Craig
 */
public class MagicPunch extends MeleeAttack {

    public MagicPunch() {
        super();
        this.name = "Magic Punch";
        this.power = 60;
        this.variance = 6;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.PUNCH);
        this.characteristics = Collections.emptyList();
    }
}
