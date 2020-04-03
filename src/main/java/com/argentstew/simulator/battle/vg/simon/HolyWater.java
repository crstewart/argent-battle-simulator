package com.argentstew.simulator.battle.vg.simon;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MagicAttack;
import com.argentstew.simulator.battle.action.attack.RangedAttack;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.simon
 * 8/27/2019
 *
 * @author Craig
 */
public class HolyWater extends MagicAttack {

    public HolyWater() {
        super();
        this.name = "Holy Water";
        this.power = 65;
        this.variance = 6;
        this.speed = 1.5;
        this.subtypes = Arrays.asList(AttackSubType.FIRE, AttackSubType.LIGHT);
        this.characteristics = Collections.emptyList();
    }
}
