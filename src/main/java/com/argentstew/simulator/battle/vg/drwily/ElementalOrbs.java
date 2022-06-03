package com.argentstew.simulator.battle.vg.drwily;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;
import com.argentstew.simulator.battle.status.StatusEffect;
import com.argentstew.simulator.battle.status.StatusType;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * com.argentstew.simulator.battle.vg.drwily
 * 8/27/2019
 *
 * @author Craig
 */
public class ElementalOrbs extends RangedAttack {

    private static final List<StatusType> POSSIBLE_EFFECTS = Arrays.asList(StatusType.BURN, StatusType.FROSTBITE,
            StatusType.PARALYSIS, StatusType.VIRUS);

    public ElementalOrbs() {
        super();
        this.name = "Elemental Orbs";
        this.description = "Has a 50% chance to inflict burn, frostbite, paralysis, or virus status for 5 turns";
        this.power = 55;
        this.variance = 8;
        this.speed = 1;
        this.subtypes = Arrays.asList(AttackSubType.FIRE, AttackSubType.ICE, AttackSubType.THUNDER);
        this.characteristics = Collections.emptyList();
    }

    @Override
    public DamageReport doAttack(Fighter defender) {
        DamageReport damageReport = super.doAttack(defender);

        if (!damageReport.isMiss() && Math.random() < 0.5) {
            StatusType effect = POSSIBLE_EFFECTS.get((int) Math.floor(Math.random() * POSSIBLE_EFFECTS.size()));
            defender.setStatus(new StatusEffect(effect, 5));
        }

        return damageReport;
    }
}
