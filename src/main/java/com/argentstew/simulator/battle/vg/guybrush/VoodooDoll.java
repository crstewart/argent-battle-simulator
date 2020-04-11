package com.argentstew.simulator.battle.vg.guybrush;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MagicAttack;
import com.argentstew.simulator.battle.action.attack.RangedAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.guybrush
 * 8/27/2019
 *
 * @author Craig
 */
public class VoodooDoll extends MagicAttack {

    public VoodooDoll() {
        super();
        this.name = "Voodoo Doll";
        this.power = 65;
        this.variance = 6;
        this.speed = 2;
        this.subtypes = Collections.singletonList(AttackSubType.DARK);
        this.characteristics = Collections.emptyList();
    }
}
