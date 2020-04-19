package com.argentstew.simulator.battle.vg.joker;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MagicAttack;
import com.argentstew.simulator.battle.action.attack.RangedAttack;
import com.argentstew.simulator.battle.fighter.Fighter;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.joker
 * 8/27/2019
 *
 * @author Craig
 */
public class DreamNeedle extends RangedAttack {

    public DreamNeedle() {
        super();
        this.name = "Dream Needle";
        this.description = "Requires Arsene, has double stun chance";
        this.power = 45;
        this.variance = 5;
        this.speed = 0.5;
        this.subtypes = Collections.singletonList(AttackSubType.PIERCE);
        this.characteristics = Collections.emptyList();
    }

    @Override
    public double getStunChance(Fighter defender, boolean isCrit) {
        return super.getStunChance(defender, isCrit) * 2;
    }

    @Override
    public boolean isDoable() {
        return Joker.PERSONA_ARSENE.equals(owner.getSelfStatus());
    }
}
