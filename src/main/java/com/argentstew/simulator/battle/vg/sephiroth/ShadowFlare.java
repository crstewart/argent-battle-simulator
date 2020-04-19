package com.argentstew.simulator.battle.vg.sephiroth;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MagicAttack;
import com.argentstew.simulator.battle.fighter.Fighter;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.sephiroth
 * 8/27/2019
 *
 * @author Craig
 */
public class ShadowFlare extends MagicAttack {

    public ShadowFlare() {
        super();
        this.name = "Shadow Flare";
        this.description = "Always critical hits";
        this.power = 50;
        this.variance = 6;
        this.speed = 2;
        this.subtypes = Collections.singletonList(AttackSubType.DARK);
        this.characteristics = Collections.emptyList();
    }

    @Override
    protected double getCritChance(Fighter defender) {
        return 1;
    }
}
