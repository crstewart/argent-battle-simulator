package com.argentstew.simulator.battle.vg.geno;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MagicAttack;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;
import com.argentstew.simulator.battle.trait.impl.StarPower;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.geno
 * 8/27/2019
 *
 * @author Craig
 */
public class GenoBeam extends MagicAttack {

    public static final int MP_COST = 3;

    public GenoBeam() {
        super();
        this.name = "Geno Beam";
        this.description = "Costs 3 SP; 33% faster and 25% weaker at Star Power 1; 100% slower and 50% stronger at Star Power 3";
        this.power = 80;
        this.variance = 6;
        this.speed = 1.5;
        this.subtypes = Collections.singletonList(AttackSubType.PLASMA);
        this.characteristics = Collections.emptyList();
    }

    @Override
    public boolean isAllowed() {
        return owner.getMp() >= MP_COST;
    }

    @Override
    public DamageReport doAttack(Fighter defender) {
        owner.useMagic(MP_COST);

        int starPower = getStarPower();
        if (starPower <= 1) {
            this.power = 60;
        } else if (starPower >= 3) {
            this.power = 120;
        } else {
            this.power = 80;
        }

        return super.doAttack(defender);
    }

    @Override
    public double calculateSpeed() {
        int starPower = getStarPower();
        if (starPower <= 1) {
            this.speed = 1;
        } else if (starPower >= 3) {
            this.speed = 3;
        } else {
            this.speed = 1.5;
        }

        return super.calculateSpeed();
    }

    private int getStarPower() {
        StarPower starPowerTrait = owner.getTraits().getTrait(StarPower.class);
        return starPowerTrait != null ? starPowerTrait.getPower() : 2;
    }
}
