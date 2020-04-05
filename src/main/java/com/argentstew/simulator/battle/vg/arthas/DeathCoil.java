package com.argentstew.simulator.battle.vg.arthas;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MagicAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.arthas
 * 8/27/2019
 *
 * @author Craig
 */
public class DeathCoil extends MagicAttack {

    public DeathCoil() {
        super();
        this.name = "Death Coil";
        this.power = 50;
        this.variance = 5;
        this.speed = 0.5;
        this.subtypes = Collections.singletonList(AttackSubType.DARK);
        this.characteristics = Collections.emptyList();
    }
}
