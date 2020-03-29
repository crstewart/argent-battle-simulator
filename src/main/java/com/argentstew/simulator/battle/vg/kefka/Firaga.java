package com.argentstew.simulator.battle.vg.kefka;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MagicAttack;
import com.argentstew.simulator.battle.fighter.Fighter;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.kefka
 * 8/27/2019
 *
 * @author Craig
 */
public class Firaga extends MagicAttack {

    public Firaga() {
        super();
        this.name = "Firaga";
        this.power = 60;
        this.variance = 12;
        this.speed = 2;
        this.subtypes = Collections.singletonList(AttackSubType.FIRE);
        this.characteristics = Collections.emptyList();
    }

    @Override
    protected double getMissChance(Fighter defender) {
        return super.getMissChance(defender) * 0.5;
    }
}
