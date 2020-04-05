package com.argentstew.simulator.battle.vg.arthas;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MagicAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.arthas
 * 8/27/2019
 *
 * @author Craig
 */
public class HowlingBlast extends MagicAttack {

    public HowlingBlast() {
        super();
        this.name = "Howling Blast";
        this.power = 55;
        this.variance = 5;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.ICE);
        this.characteristics = Collections.emptyList();
    }
}
