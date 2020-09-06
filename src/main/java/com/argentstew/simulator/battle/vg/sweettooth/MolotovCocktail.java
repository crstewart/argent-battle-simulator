package com.argentstew.simulator.battle.vg.sweettooth;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.sweettooth
 * 8/24/2019
 *
 * @author Craig
 */
public class MolotovCocktail extends RangedAttack {

    private int ammo;

    public MolotovCocktail() {
        super();
        this.name = "Molotov Cocktail";
        this.power = 80;
        this.variance = 10;
        this.speed = 3;
        this.subtypes = Collections.singletonList(AttackSubType.FIRE);
        this.characteristics = Collections.emptyList();
    }
}
