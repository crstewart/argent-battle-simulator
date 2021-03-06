package com.argentstew.simulator.battle.vg.thrall;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MagicAttack;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;
import com.argentstew.simulator.battle.action.attack.RangedAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.thrall
 * 8/27/2019
 *
 * @author Craig
 */
public class ChainLightning extends MagicAttack {

    public ChainLightning() {
        super();
        this.name = "Chain Lightning";
        this.power = 50;
        this.variance = 7;
        this.speed = 1.5;
        this.subtypes = Collections.singletonList(AttackSubType.THUNDER);
        this.characteristics = Collections.emptyList();
    }
}
