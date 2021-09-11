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
public class GenoWhirl extends MagicAttack {

    public static final int MP_COST = 8;

    public GenoWhirl() {
        super();
        this.name = "Geno Whirl";
        this.description = "Costs 8 SP; Can only hit critically on Star Power 2, but does so for 5x damage";
        this.power = 30;
        this.variance = 3;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.LIGHT);
        this.characteristics = Collections.emptyList();
    }

    @Override
    public boolean isAllowed() {
        return owner.getMp() >= MP_COST;
    }

    @Override
    public DamageReport doAttack(Fighter defender) {
        owner.useMagic(MP_COST);
        return super.doAttack(defender);
    }

    @Override
    protected double getCritChance(Fighter defender) {
        return getStarPower() == 2 ? 1 : 0;
    }

    @Override
    protected double getCritMultiplier(Fighter defender) {
        return 5;
    }

    private int getStarPower() {
        StarPower starPowerTrait = owner.getTraits().getTrait(StarPower.class);
        return starPowerTrait != null ? starPowerTrait.getPower() : 2;
    }
}
