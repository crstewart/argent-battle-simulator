package com.argentstew.simulator.battle.vg.subzero;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;
import com.argentstew.simulator.battle.fighter.Fighter;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.subzero
 * 8/27/2019
 *
 * @author Craig
 */
public class IceShower extends RangedAttack {

    public IceShower() {
        super();
        this.name = "Ice Shower";
        this.power = 60;
        this.variance = 5;
        this.speed = 1.5;
        this.subtypes = Collections.singletonList(AttackSubType.ICE);
        this.characteristics = Collections.emptyList();
    }
}
