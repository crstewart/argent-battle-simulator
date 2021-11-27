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
public class Zionga extends MagicAttack {

    public Zionga() {
        super();
        this.name = "Zionga";
        this.description = "Requires Izanagi; has 25% chance to apply slow status for 3 turns";
        this.power = 50;
        this.variance = 10;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.THUNDER);
        this.characteristics = Collections.emptyList();
    }

    @Override
    public DamageReport doAttack(Fighter defender) {
        DamageReport damageReport = super.doAttack(defender);
        if (!damageReport.isMiss() && damageReport.getDamage() > 0) {
            double rng = Math.random();
            if (rng >= 0.75) {
                defender.setStatus(new StatusEffect(StatusType.SLOW, 3));
            }
        }

        return damageReport;
    }

    @Override
    public boolean isAllowed() {
        return Joker.PERSONA_IZANAGI.equals(owner.getSelfStatus());
    }
}
