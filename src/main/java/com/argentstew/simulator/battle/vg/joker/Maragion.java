package com.argentstew.simulator.battle.vg.joker;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MagicAttack;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;
import com.argentstew.simulator.battle.status.StatusEffect;
import com.argentstew.simulator.battle.status.StatusType;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.joker
 * 8/27/2019
 *
 * @author Craig
 */
public class Maragion extends MagicAttack {

    public Maragion() {
        super();
        this.name = "Maragion";
        this.description = "Requires Orpheus; has 25% chance to apply burn status for 3 turns";
        this.power = 70;
        this.variance = 8;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.FIRE);
        this.characteristics = Collections.emptyList();
    }

    @Override
    public DamageReport doAttack(Fighter defender) {
        DamageReport damageReport = super.doAttack(defender);
        if (!damageReport.isMiss() && damageReport.getDamage() > 0) {
            double rng = Math.random();
            if (rng >= 0.75) {
                defender.setStatus(new StatusEffect(StatusType.BURN, 3));
            }
        }

        return damageReport;
    }

    @Override
    public boolean isAllowed() {
        return Joker.PERSONA_ORPHEUS.equals(owner.getSelfStatus());
    }
}
