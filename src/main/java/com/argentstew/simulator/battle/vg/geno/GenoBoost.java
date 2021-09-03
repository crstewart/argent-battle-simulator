package com.argentstew.simulator.battle.vg.geno;

import com.argentstew.simulator.battle.action.AttackAction;
import com.argentstew.simulator.battle.action.defense.Guard;
import com.argentstew.simulator.battle.trait.impl.StarPower;

/**
 * com.argentstew.simulator.battle.vg.geno
 * 8/27/2019
 *
 * @author Craig
 */
public class GenoBoost extends Guard {

    public static final String GENO_BOOST_STATUS = "Geno Boost";

    public static final int MP_COST = 4;

    public GenoBoost() {
        this.name = "Geno Boost";
        this.description = "Costs 4 SP; reduces damage by 50% on Star Power 2 but always grants 2 additional damage on the next ranged attack";
        this.initiateMessage = "uses Geno Boost!";
        this.successMessage = "gained an attack boost and resisted the attack!";
        this.failureMessage = "gained an attack boost but could not resist the attack!";
        this.speed = 1;
    }

    @Override
    protected boolean doesGuardAttack(AttackAction attack) {
        this.owner.useMagic(MP_COST);
        this.owner.setSelfStatus(GENO_BOOST_STATUS);
        return getStarPower() == 2;
    }

    @Override
    public int applyDefense(int damage) {
        return (int) Math.round(damage / 2.0);
    }

    @Override
    public AttackAction doCounterAttack(AttackAction attack, int damage) {
        return null;
    }

    @Override
    public boolean isDoable() {
        return owner.getMp() >= MP_COST;
    }

    private int getStarPower() {
        StarPower starPowerTrait = owner.getTraits().getTrait(StarPower.class);
        return starPowerTrait != null ? starPowerTrait.getPower() : 2;
    }
}
