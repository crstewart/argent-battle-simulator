package com.argentstew.simulator.battle.vg.megaman;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.megaman
 * 8/24/2019
 *
 * @author Craig
 */
public class HardKnuckle extends RangedAttack {

    public HardKnuckle() {
        super();
        this.name = "Hard Knuckle";
        this.power = 70;
        this.variance = 4;
        this.speed = 2;
        this.subtypes = Arrays.asList(AttackSubType.PUNCH);
        this.characteristics = Collections.emptyList();
    }
}
