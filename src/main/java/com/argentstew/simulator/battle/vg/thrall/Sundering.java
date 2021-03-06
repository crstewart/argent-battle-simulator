package com.argentstew.simulator.battle.vg.thrall;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MagicAttack;
import com.argentstew.simulator.battle.action.attack.RangedAttack;
import com.argentstew.simulator.battle.fighter.Fighter;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.thrall
 * 8/27/2019
 *
 * @author Craig
 */
public class Sundering extends RangedAttack {

    public Sundering() {
        super();
        this.name = "Sundering";
        this.description = "Has 50% additional stun chance";
        this.power = 70;
        this.variance = 5;
        this.speed = 3;
        this.subtypes = Collections.singletonList(AttackSubType.EARTH);
        this.characteristics = Collections.emptyList();
    }

    @Override
    public double getStunChance(Fighter defender, boolean isCrit) {
        return super.getStunChance(defender, isCrit) * 1.5;
    }
}
