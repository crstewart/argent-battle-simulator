package com.argentstew.simulator.battle.vg.sans;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MagicAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.sans
 * 8/27/2019
 *
 * @author Craig
 */
public class BoneAttack extends MagicAttack {

    public BoneAttack() {
        super();
        this.name = "Bone Attack";
        this.power = 60;
        this.variance = 12;
        this.speed = 2;
        this.subtypes = Collections.emptyList();
        this.characteristics = Collections.emptyList();
    }
}
