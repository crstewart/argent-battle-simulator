package com.argentstew.simulator.battle.vg.kefka;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
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
public class HavocWing extends MagicAttack {

    public HavocWing() {
        super();
        this.name = "Havoc Wing";
        this.description = "Always critical hits";
        this.power = 40;
        this.variance = 6;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.WING);
        this.characteristics = Collections.emptyList();
        this.setRequiresMeleeRange(true);
    }

    @Override
    protected double getCritChance(Fighter defender) {
        return 1;
    }
}
