package com.argentstew.simulator.battle.vg.ezio;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;
import com.argentstew.simulator.battle.fighter.Fighter;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.ezio
 * 8/27/2019
 *
 * @author Craig
 */
public class HiddenGun extends RangedAttack {

    public HiddenGun() {
        super();
        this.name = "Hidden Gun";
        this.description = "Has 150% normal critical hit chance";
        this.power = 60;
        this.variance = 6;
        this.speed = 2;
        this.subtypes = Collections.singletonList(AttackSubType.HANDGUN);
        this.characteristics = Collections.singletonList(AttackCharacteristic.BULLET_SPEED);
    }

    @Override
    public double getCritChance(Fighter defender) {
        return super.getCritChance(defender) * 1.5;
    }
}
