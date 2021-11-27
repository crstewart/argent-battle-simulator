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
public class CrossSlash extends MeleeAttack {

    public CrossSlash() {
        super();
        this.name = "Cross Slash";
        this.description = "Requires Izanagi";
        this.power = 90;
        this.variance = 8;
        this.speed = 1.5;
        this.subtypes = Collections.singletonList(AttackSubType.SLASH);
        this.characteristics = Collections.emptyList();
    }

    @Override
    public boolean isAllowed() {
        return Joker.PERSONA_IZANAGI.equals(owner.getSelfStatus());
    }
}
