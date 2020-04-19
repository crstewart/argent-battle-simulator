package com.argentstew.simulator.battle.vg.sephiroth;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;
import com.argentstew.simulator.battle.fighter.Fighter;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.sephiroth
 * 8/27/2019
 *
 * @author Craig
 */
public class Octaslash extends MeleeAttack {

    public Octaslash() {
        super();
        this.name = "Octaslash";
        this.description = "Always critical hits";
        this.power = 40;
        this.variance = 8;
        this.speed = 2;
        this.subtypes = Collections.singletonList(AttackSubType.SLASH);
        this.characteristics = Collections.emptyList();
    }

    @Override
    protected double getCritChance(Fighter defender) {
        return 1;
    }
}
