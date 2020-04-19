package com.argentstew.simulator.battle.vg.joker;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MagicAttack;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.joker
 * 8/27/2019
 *
 * @author Craig
 */
public class VacuumWave extends MagicAttack {

    public VacuumWave() {
        super();
        this.name = "Vacuum Wave";
        this.description = "Requires Vishnu";
        this.power = 80;
        this.variance = 7;
        this.speed = 1.5;
        this.subtypes = Collections.singletonList(AttackSubType.AIR);
        this.characteristics = Collections.singletonList(AttackCharacteristic.UNDODGEABLE);
    }

    @Override
    public boolean isDoable() {
        return Joker.PERSONA_VISHNU.equals(owner.getSelfStatus());
    }
}
