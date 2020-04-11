package com.argentstew.simulator.battle.vg.geralt;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MagicAttack;
import com.argentstew.simulator.battle.action.attack.RangedAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.geralt
 * 9/7/2019
 *
 * @author Craig
 */
public class GrapeshotBomb extends RangedAttack {

    public GrapeshotBomb() {
        super();
        this.name = "Grapeshot Bomb";
        this.power = 80;
        this.variance = 8;
        this.speed = 3;
        this.subtypes = Collections.singletonList(AttackSubType.EXPLOSIVE);
        this.characteristics = Collections.emptyList();
    }
}
