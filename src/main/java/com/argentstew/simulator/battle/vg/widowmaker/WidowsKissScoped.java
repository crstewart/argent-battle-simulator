package com.argentstew.simulator.battle.vg.widowmaker;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.widowmaker
 * 8/27/2019
 *
 * @author Craig
 */
public class WidowsKissScoped extends RangedAttack {

    public WidowsKissScoped() {
        super();
        this.name = "Widow's Kiss (Scoped)";
        this.power = 90;
        this.variance = 10;
        this.speed = 4;
        this.subtypes = Collections.singletonList(AttackSubType.RIFLE);
        this.characteristics = Collections.singletonList(AttackCharacteristic.BULLET_SPEED);
    }
}
