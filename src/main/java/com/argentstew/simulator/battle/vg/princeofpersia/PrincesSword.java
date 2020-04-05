package com.argentstew.simulator.battle.vg.princeofpersia;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.princeofpersia
 * 8/27/2019
 *
 * @author Craig
 */
public class PrincesSword extends MeleeAttack {

    public PrincesSword() {
        super();
        this.name = "Prince's Sword";
        this.power = 65;
        this.variance = 6;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.SLASH);
        this.characteristics = Collections.emptyList();
    }
}
