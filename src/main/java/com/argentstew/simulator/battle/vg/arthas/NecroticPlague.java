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
public class NecroticPlague extends MagicAttack {

    public NecroticPlague() {
        super();
        this.name = "Necrotic Plague";
        this.power = 60;
        this.variance = 6;
        this.speed = 1.5;
        this.subtypes = Collections.singletonList(AttackSubType.TOXIC);
        this.characteristics = Collections.emptyList();
    }
}
