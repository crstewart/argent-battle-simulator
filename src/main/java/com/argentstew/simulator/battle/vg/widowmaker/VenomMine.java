package com.argentstew.simulator.battle.vg.widowmaker;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.widowmaker
 * 8/27/2019
 *
 * @author Craig
 */
public class VenomMine extends RangedAttack {

    public VenomMine() {
        super();
        this.name = "Venom Mine";
        this.power = 30;
        this.variance = 6;
        this.speed = 0.5;
        this.subtypes = Collections.singletonList(AttackSubType.TOXIC);
        this.characteristics = Collections.emptyList();
    }
}
