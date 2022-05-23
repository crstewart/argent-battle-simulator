package com.argentstew.simulator.battle.vg.charizard;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;
import com.argentstew.simulator.battle.action.attack.RangedAttack;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.fighter.FighterClassification;
import com.argentstew.simulator.battle.reporting.DamageReport;
import com.argentstew.simulator.battle.status.StatusEffect;
import com.argentstew.simulator.battle.status.StatusType;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.charizard
 * 9/8/2019
 *
 * @author Craig
 */
public class DragonClaw extends MeleeAttack {

    public DragonClaw() {
        super();
        this.name = "Dragon Claw";
        this.description = "Deals double damage to dragons, half damage to mechs";
        this.power = 80;
        this.variance = 7;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.CLAW);
        this.characteristics = Collections.emptyList();
    }

    private int modifyDamage(Fighter defender, int damage) {
        if (defender.getClassifications().contains(FighterClassification.DRAGON)) {
            return (int) Math.round(damage * 2);
        } else if (defender.getClassifications().contains(FighterClassification.MECH)) {
            return (int) Math.round(damage * 0.5);
        }

        return damage;
    }
}
