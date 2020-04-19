package com.argentstew.simulator.battle.vg.leonkennedy;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.ryu
 * 8/24/2019
 *
 * @author Craig
 */
public class ChemicalFlamethrower extends RangedAttack {

    private int ammo;

    public ChemicalFlamethrower() {
        super();
        this.name = "Chemical Flamethrower";
        this.description = "100 ammo, each attack uses 25 ammo";
        this.power = 65;
        this.variance = 5;
        this.speed = 1;
        this.ammo = 100;
        this.subtypes = Collections.singletonList(AttackSubType.FIRE);
        this.characteristics = Collections.emptyList();
    }

    @Override
    public DamageReport doAttack(Fighter defender) {
        ammo -= 25;
        return super.doAttack(defender);
    }

    @Override
    public boolean isDoable() {
        return ammo > 0;
    }
}
