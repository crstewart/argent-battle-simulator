package com.argentstew.simulator.battle.vg.draven;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;
import com.argentstew.simulator.battle.fighter.Fighter;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.draven
 * 8/24/2019
 *
 * @author Craig
 */
public class SpinningAxe extends RangedAttack {

    public SpinningAxe() {
        super();
        this.name = "Spinning Axe";
        this.power = 75;
        this.variance = 7;
        this.speed = 2;
        this.subtypes = Collections.singletonList(AttackSubType.HACK);
        this.characteristics = Collections.emptyList();
    }
}
