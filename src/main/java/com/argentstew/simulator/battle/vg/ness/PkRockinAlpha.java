package com.argentstew.simulator.battle.vg.ness;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.ness
 * 8/27/2019
 *
 * @author Craig
 */
public class PkRockinAlpha extends RangedAttack {

    public static final int MP_COST = 10;

    public PkRockinAlpha() {
        super();
        this.name = "PK Rockin Alpha";
        this.power = 80;
        this.variance = 4;
        this.speed = 1.5;
        this.subtypes = Collections.singletonList(AttackSubType.MYSTIC);
        this.characteristics = Collections.emptyList();
    }

    @Override
    public DamageReport doAttack(Fighter defender) {
        owner.useMagic(MP_COST);
        return super.doAttack(defender);
    }

    @Override
    public boolean isDoable() {
        return owner.getMp() >= MP_COST;
    }
}
