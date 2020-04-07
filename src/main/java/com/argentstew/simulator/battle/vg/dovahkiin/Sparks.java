package com.argentstew.simulator.battle.vg.dovahkiin;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MagicAttack;
import com.argentstew.simulator.battle.action.attack.RangedAttack;
import com.argentstew.simulator.battle.fighter.Fighter;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.dovahkiin
 * 8/27/2019
 *
 * @author Craig
 */
public class Sparks extends MagicAttack {

    public Sparks() {
        super();
        this.name = "Sparks";
        this.power = 55;
        this.variance = 8;
        this.speed = 1.5;
        this.subtypes = Collections.singletonList(AttackSubType.THUNDER);
        this.characteristics = Collections.emptyList();
    }
}
