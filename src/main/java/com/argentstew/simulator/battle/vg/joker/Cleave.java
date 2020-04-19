package com.argentstew.simulator.battle.vg.joker;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MagicAttack;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.joker
 * 8/27/2019
 *
 * @author Craig
 */
public class Cleave extends MeleeAttack {

    public Cleave() {
        super();
        this.name = "Cleave";
        this.description = "Requires Arsene";
        this.power = 95;
        this.variance = 9;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.SLASH);
        this.characteristics = Collections.emptyList();
    }

    @Override
    public boolean isDoable() {
        return Joker.PERSONA_ARSENE.equals(owner.getSelfStatus());
    }
}
