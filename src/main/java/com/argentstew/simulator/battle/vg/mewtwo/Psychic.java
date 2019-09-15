package com.argentstew.simulator.battle.vg.mewtwo;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.mewtwo
 * 9/15/2019
 *
 * @author Craig
 */
public class Psychic extends RangedAttack {

    public Psychic() {
        super();
        this.name = "Psychic";
        this.power = 90;
        this.variance = 6;
        this.speed = 2.5;
        this.subtypes = Collections.singletonList(AttackSubType.MYSTIC);
        this.characteristics = Collections.emptyList();
    }
}
