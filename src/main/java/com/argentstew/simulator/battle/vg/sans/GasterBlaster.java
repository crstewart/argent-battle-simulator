package com.argentstew.simulator.battle.vg.sans;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MagicAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.sans
 * 8/27/2019
 *
 * @author Craig
 */
public class GasterBlaster extends MagicAttack {

    public GasterBlaster() {
        super();
        this.name = "Gaster Blaster";
        this.power = 80;
        this.variance = 10;
        this.speed = 1.5;
        this.subtypes = Collections.singletonList(AttackSubType.PLASMA);
        this.characteristics = Collections.emptyList();
    }
}
