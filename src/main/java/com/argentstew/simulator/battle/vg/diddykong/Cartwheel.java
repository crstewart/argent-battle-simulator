package com.argentstew.simulator.battle.vg.diddykong;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;
import com.argentstew.simulator.battle.action.attack.RangedAttack;
import com.argentstew.simulator.battle.fighter.Fighter;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.diddykong
 * 8/26/2019
 *
 * @author Craig
 */
public class Cartwheel extends MeleeAttack {

    public Cartwheel() {
        super();
        this.name = "Cartwheel";
        this.power = 45;
        this.variance = 5;
        this.speed = 0.5;
        this.subtypes = Arrays.asList(AttackSubType.PUNCH, AttackSubType.KICK);
        this.characteristics = Collections.emptyList();
    }
}
