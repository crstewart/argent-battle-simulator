package com.argentstew.simulator.battle.vg.geno;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MagicAttack;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;
import com.argentstew.simulator.battle.trait.impl.StarPower;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.geno
 * 8/27/2019
 *
 * @author Craig
 */
public class GenoBlast extends MagicAttack {

    public static final int MP_COST = 12;

    public GenoBlast() {
        super();
        this.name = "Geno Blast";
        this.description = "Costs 12 SP; 50% faster and 33% weaker at Star Power 1; 100% slower and 50% stronger at Star Power 3";
        this.power = 90;
        this.variance = 9;
        this.speed = 3;
        this.subtypes = Arrays.asList(AttackSubType.LIGHT, AttackSubType.EXPLOSIVE);
        this.characteristics = Collections.singletonList(AttackCharacteristic.UNDODGEABLE);
    }

    @Override
    public boolean isDoable() {
        return super.isDoable() && owner.getMp() >= MP_COST;
    }

    @Override
    public DamageReport doAttack(Fighter defender) {
        owner.useMagic(MP_COST);

        int starPower = getStarPower();
        if (starPower <= 1) {
            this.power = 60;
        } else if (starPower >= 3) {
            this.power = 135;
        } else {
            this.power = 90;
        }

        return super.doAttack(defender);
    }

    @Override
    public double calculateSpeed() {
        int starPower = getStarPower();
        if (starPower <= 1) {
            this.speed = 1.5;
        } else if (starPower >= 3) {
            this.speed = 6;
        } else {
            this.speed = 3;
        }

        return super.calculateSpeed();
    }

    private int getStarPower() {
        StarPower starPowerTrait = owner.getTraits().getTrait(StarPower.class);
        return starPowerTrait != null ? starPowerTrait.getPower() : 2;
    }
}
