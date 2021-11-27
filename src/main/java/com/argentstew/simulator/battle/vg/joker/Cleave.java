package com.argentstew.simulator.battle.vg.joker;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;
import com.argentstew.simulator.battle.fighter.Fighter;

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
        this.description = "Requires Arsene; has 20% additional critical hit rate against stealthed foes";
        this.power = 90;
        this.variance = 9;
        this.speed = 2;
        this.subtypes = Collections.singletonList(AttackSubType.SLASH);
        this.characteristics = Collections.emptyList();
    }

    @Override
    public double getCritChance(Fighter defender) {
        double critChance = super.getCritChance(defender);
        if (defender.isStealth()) {
            critChance += 0.2;
        }

        return critChance;
    }

    @Override
    public boolean isAllowed() {
        return Joker.PERSONA_ARSENE.equals(owner.getSelfStatus());
    }
}
