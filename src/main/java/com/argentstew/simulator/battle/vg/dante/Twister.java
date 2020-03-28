package com.argentstew.simulator.battle.vg.dante;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MagicAttack;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.dante
 * 8/27/2019
 *
 * @author Craig
 */
public class Twister extends MagicAttack {

    public Twister() {
        super();
        this.name = "Twister";
        this.power = 65;
        this.variance = 5;
        this.speed = 1;
        this.subtypes = Arrays.asList(AttackSubType.FIRE, AttackSubType.AIR);
        this.characteristics = Collections.emptyList();
        this.setRequiresMeleeRange(true);
    }
}
