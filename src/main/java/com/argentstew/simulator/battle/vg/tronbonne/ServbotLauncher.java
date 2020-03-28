package com.argentstew.simulator.battle.vg.tronbonne;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.tronbonne
 * 8/24/2019
 *
 * @author Craig
 */
public class ServbotLauncher extends RangedAttack {

    public ServbotLauncher() {
        super();
        this.name = "Servbot Launcher";
        this.power = 40;
        this.variance = 4;
        this.speed = 0.5;
        this.subtypes = Collections.singletonList(AttackSubType.ASSIST);
        this.characteristics = Collections.emptyList();
    }
}
