package com.argentstew.simulator.battle.vg.joker;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.joker
 * 8/27/2019
 *
 * @author Craig
 */
public class BraveBlade extends MeleeAttack {

    public BraveBlade() {
        super();
        this.name = "Brave Blade";
        this.power = 120;
        this.variance = 12;
        this.speed = 2;
        this.subtypes = Collections.singletonList(AttackSubType.SLASH);
        this.characteristics = Collections.emptyList();
    }

    @Override
    public boolean isDoable() {
        return Joker.PERSONA_FUTSUNUSHI.equals(owner.getSelfStatus());
    }
}
