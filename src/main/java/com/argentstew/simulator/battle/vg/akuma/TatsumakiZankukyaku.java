package com.argentstew.simulator.battle.vg.akuma;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.ryu
 * 8/24/2019
 *
 * @author Craig
 */
public class TatsumakiZankukyaku extends MeleeAttack {

    public TatsumakiZankukyaku() {
        super();
        this.name = "Tatsumaki Zankukyaku";
        this.power = 70;
        this.variance = 9;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.KICK);
        this.characteristics = Collections.emptyList();
    }
}
