package com.argentstew.simulator.battle.vg.widowmaker;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;
import com.argentstew.simulator.battle.status.StatusEffect;
import com.argentstew.simulator.battle.status.StatusType;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.widowmaker
 * 8/27/2019
 *
 * @author Craig
 */
public class VenomMine extends RangedAttack {

    private int uses;

    public VenomMine() {
        super();
        this.name = "Venom Mine";
        this.description = "Has two uses; applies poison status for three turns on hit";
        this.power = 10;
        this.variance = 1;
        this.speed = 0.5;
        this.subtypes = Collections.singletonList(AttackSubType.TOXIC);
        this.characteristics = Collections.emptyList();
        this.uses = 2;
    }

    @Override
    public DamageReport doAttack(Fighter defender) {
        uses--;
        DamageReport damageReport = super.doAttack(defender);
        if (!damageReport.isMiss()) {
            defender.setStatus(new StatusEffect(StatusType.POISON, 3));
        }

        return damageReport;
    }

    @Override
    public boolean isAllowed() {
        return this.uses > 0;
    }
}
