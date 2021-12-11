package com.argentstew.simulator.battle.vg.geno;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.trait.impl.StarPower;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.geno
 * 8/27/2019
 *
 * @author Craig
 */
public class StarGun extends RangedAttack {

    public StarGun() {
        super();
        this.name = "Star Gun";
        this.description = "Does 50% bonus damage and cannot miss on Star Power 2";
        this.power = 50;
        this.variance = 5;
        this.speed = 2.5;
        this.subtypes = Collections.singletonList(AttackSubType.LIGHT);
        this.characteristics = Collections.singletonList(AttackCharacteristic.BULLET_SPEED);
    }

    @Override
    protected double getBaseDamage() {
        double damage = super.getBaseDamage();

        if (getStarPower() == 2) {
            damage *= 1.5;
        }

        return damage;
    }

    @Override
    protected double getMissChance(Fighter defender) {
        if (defender.isStealth() || getStarPower() != 2) {
            return super.getMissChance(defender);
        }

        return 0;
    }

    private int getStarPower() {
        StarPower starPowerTrait = owner.getTraits().getTrait(StarPower.class);
        return starPowerTrait != null ? starPowerTrait.getPower() : 2;
    }
}
