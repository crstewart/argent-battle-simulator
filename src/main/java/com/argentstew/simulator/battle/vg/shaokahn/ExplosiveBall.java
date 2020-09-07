package com.argentstew.simulator.battle.vg.shaokahn;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MagicAttack;
import com.argentstew.simulator.battle.action.attack.RangedAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.shaokahn
 * 8/27/2019
 *
 * @author Craig
 */
public class ExplosiveBall extends MagicAttack {

    public ExplosiveBall() {
        super();
        this.name = "Explosive Ball";
        this.power = 75;
        this.variance = 7;
        this.speed = 2;
        this.subtypes = Collections.singletonList(AttackSubType.FIRE);
        this.characteristics = Collections.emptyList();
    }
}
