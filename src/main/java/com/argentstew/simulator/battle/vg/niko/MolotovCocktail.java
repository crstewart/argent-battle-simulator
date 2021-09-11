package com.argentstew.simulator.battle.vg.niko;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;
import com.argentstew.simulator.battle.status.StatusEffect;
import com.argentstew.simulator.battle.status.StatusType;

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
        this.power = 35;
        this.variance = 5;
        this.speed = 3;
        this.subtypes = Arrays.asList(AttackSubType.EXPLOSIVE, AttackSubType.FIRE);
        this.characteristics = Collections.singletonList(AttackCharacteristic.UNDODGEABLE);
    }

    @Override
    public DamageReport doAttack(Fighter defender) {
        DamageReport damageReport = super.doAttack(defender);
        if (!damageReport.isMiss() && damageReport.getDamage() > 0) {
            defender.setStatus(new StatusEffect(StatusType.BURN, 3));
        }

        return damageReport;
    }
}
