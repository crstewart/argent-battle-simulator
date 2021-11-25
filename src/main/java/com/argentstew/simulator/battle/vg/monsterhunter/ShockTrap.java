package com.argentstew.simulator.battle.vg.monsterhunter;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;
import com.argentstew.simulator.battle.fighter.Fighter;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.monsterhunter
 * 8/24/2019
 *
 * @author Craig
 */
public class ShockTrap extends RangedAttack {

    public ShockTrap() {
        super();
        this.name = "Shock Trap";
        this.description = "Has a 50% chance to stun";
        this.power = 10;
        this.variance = 2;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.THUNDER);
        this.characteristics = Collections.emptyList();
    }

    @Override
    public double getStunChance(Fighter defender, boolean isCrit) {
        return 0.5;
    }
}
