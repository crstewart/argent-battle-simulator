package com.argentstew.simulator.battle.vg.diddykong;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;
import com.argentstew.simulator.battle.fighter.Fighter;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.diddykong
 * 8/26/2019
 *
 * @author Craig
 */
public class BananaPeel extends RangedAttack {

    public BananaPeel() {
        super();
        this.name = "Banana Peel";
        this.description = "Has 60% additional stun chance";
        this.power = 10;
        this.variance = 3;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.NATURE);
        this.characteristics = Collections.emptyList();
    }

    @Override
    protected double getStunChance(Fighter defender, boolean isCrit) {
        double stunChance = super.getStunChance(defender, isCrit);
        return stunChance + 0.6;
    }
}
