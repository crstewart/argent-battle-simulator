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
public class MyriadSlashes extends MeleeAttack {

    public MyriadSlashes() {
        super();
        this.name = "Myriad Slashes";
        this.description = "Requires Futsunushi";
        this.power = 60;
        this.variance = 15;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.SLASH);
        this.characteristics = Collections.emptyList();
    }

    @Override
    public boolean isDoable() {
        return Joker.PERSONA_FUTSUNUSHI.equals(owner.getSelfStatus());
    }
}
