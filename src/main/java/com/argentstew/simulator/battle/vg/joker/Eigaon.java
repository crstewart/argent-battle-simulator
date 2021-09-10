package com.argentstew.simulator.battle.vg.joker;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MagicAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.joker
 * 8/27/2019
 *
 * @author Craig
 */
public class Eigaon extends MagicAttack {

    public Eigaon() {
        super();
        this.name = "Eigaon";
        this.description = "Requires Arsene";
        this.power = 60;
        this.variance = 12;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.DARK);
        this.characteristics = Collections.emptyList();
    }

    @Override
    public boolean isDoable() {
        return super.isDoable() && Joker.PERSONA_ARSENE.equals(owner.getSelfStatus());
    }
}
