package com.argentstew.simulator.battle.vg.rathalos;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;
import com.argentstew.simulator.battle.fighter.Fighter;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.rathalos
 * 8/24/2019
 *
 * @author Craig
 */
public class SonicRoar extends RangedAttack {

    public SonicRoar() {
        super();
        this.name = "Sonic Roar";
        this.description = "Has double stun chance";
        this.power = 55;
        this.variance = 5;
        this.speed = 2;
        this.subtypes = Collections.singletonList(AttackSubType.SOUND);
        this.characteristics = Collections.emptyList();
    }

    @Override
    protected double getStunChance(Fighter defender, boolean isCrit) {
        return super.getStunChance(defender, isCrit) * 2;
    }
}
