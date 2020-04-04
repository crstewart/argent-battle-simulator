package com.argentstew.simulator.battle.vg.niko;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;
import com.argentstew.simulator.battle.action.attack.RangedAttack;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.niko
 * 8/27/2019
 *
 * @author Craig
 */
public class MolotovCocktail extends RangedAttack {

    public MolotovCocktail() {
        super();
        this.name = "Molotov Cocktail";
        this.power = 55;
        this.variance = 5;
        this.speed = 2.5;
        this.subtypes = Arrays.asList(AttackSubType.EXPLOSIVE, AttackSubType.FIRE);
        this.characteristics = Collections.singletonList(AttackCharacteristic.UNDODGEABLE);
    }
}
