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

    public static final int MP_COST = 4;

    public GenoBoost() {
        this.name = "Geno Boost";
        this.description = "Costs 4 SP; reduces damage by 50% on Star Power 2 but always increases strength by 1 to a maximum of 10";
        this.initiateMessage = "uses Geno Boost!";
        this.successMessage = "increased strength and resisted the attack!";
        this.failureMessage = "increased strength but could not resist the attack!";
        this.speed = 1;
    }

    @Override
    protected boolean doesGuardAttack(AttackAction attack) {
        this.owner.useMagic(MP_COST);
        this.owner.getStats().setStrength(this.owner.getStats().getStrength() + 1);
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
    public boolean isAllowed() {
        return owner.getMp() >= MP_COST;
    }

    private int getStarPower() {
        StarPower starPowerTrait = owner.getTraits().getTrait(StarPower.class);
        return starPowerTrait != null ? starPowerTrait.getPower() : 2;
    }
}
