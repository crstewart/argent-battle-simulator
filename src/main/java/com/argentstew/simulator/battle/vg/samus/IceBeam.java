package com.argentstew.simulator.battle.vg.samus;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.samus
 * 11/10/2019
 *
 * @author Craig
 */
public class IceBeam extends RangedAttack {

    public IceBeam() {
        super();
        this.name = "Ice Beam";
        this.power = 70;
        this.variance = 4;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.ICE);
        this.characteristics = Collections.emptyList();
    }
}
