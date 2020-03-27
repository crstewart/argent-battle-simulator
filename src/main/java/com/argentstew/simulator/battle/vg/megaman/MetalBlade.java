package com.argentstew.simulator.battle.vg.megaman;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.megaman
 * 8/24/2019
 *
 * @author Craig
 */
public class MetalBlade extends RangedAttack {

    public MetalBlade() {
        super();
        this.name = "Metal Blade";
        this.power = 45;
        this.variance = 5;
        this.speed = 1;
        this.subtypes = Arrays.asList(AttackSubType.METAL, AttackSubType.HACK);
        this.characteristics = Collections.emptyList();
    }
}
