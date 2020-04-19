package com.argentstew.simulator.battle.vg.subzero;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MagicAttack;
import com.argentstew.simulator.battle.action.attack.RangedAttack;
import com.argentstew.simulator.battle.fighter.Fighter;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.subzero
 * 8/27/2019
 *
 * @author Craig
 */
public class IceBlast extends RangedAttack {

    public IceBlast() {
        super();
        this.name = "Ice Blast";
        this.description = "Always stuns the opponent";
        this.power = 20;
        this.variance = 3;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.ICE);
        this.characteristics = Collections.emptyList();
    }

    @Override
    protected double getStunChance(Fighter defender, boolean isCrit) {
        return 1;
    }
}
