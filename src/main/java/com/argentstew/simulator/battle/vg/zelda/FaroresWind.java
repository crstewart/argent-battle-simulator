package com.argentstew.simulator.battle.vg.zelda;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MagicAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.zelda
 * 8/27/2019
 *
 * @author Craig
 */
public class FaroresWind extends MagicAttack {

    public FaroresWind() {
        super();
        this.name = "Farore's Wind";
        this.power = 65;
        this.variance = 5;
        this.speed = 0.5;
        this.subtypes = Collections.singletonList(AttackSubType.AIR);
        this.characteristics = Collections.emptyList();
        this.setRequiresMeleeRange(true);
    }
}
