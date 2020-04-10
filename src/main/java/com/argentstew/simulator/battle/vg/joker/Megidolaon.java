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
public class Megidolaon extends MagicAttack {

    public Megidolaon() {
        super();
        this.name = "Megidolaon";
        this.power = 80;
        this.variance = 8;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.LIGHT);
        this.characteristics = Collections.emptyList();
    }

    @Override
    public boolean isDoable() {
        return Joker.PERSONA_VISHNU.equals(owner.getSelfStatus());
    }
}
