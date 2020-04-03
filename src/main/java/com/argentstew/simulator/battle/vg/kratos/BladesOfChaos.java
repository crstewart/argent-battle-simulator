package com.argentstew.simulator.battle.vg.kratos;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.kratos
 * 8/27/2019
 *
 * @author Craig
 */
public class BladesOfChaos extends MeleeAttack {

    public BladesOfChaos() {
        super();
        this.name = "Blades of Chaos";
        this.power = 55;
        this.variance = 5;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.SLASH);
        this.characteristics = Collections.emptyList();
    }
}
