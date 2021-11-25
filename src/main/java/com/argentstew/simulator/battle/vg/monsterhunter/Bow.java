package com.argentstew.simulator.battle.vg.monsterhunter;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.RangedAttack;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.monsterhunter
 * 8/24/2019
 *
 * @author Craig
 */
public class Bow extends RangedAttack {

    public Bow() {
        super();
        this.name = "Bow";
        this.description = "Reduces priority by 5 to equip; always stuns on crit";
        this.power = 40;
        this.variance = 3;
        this.speed = 1.5;
        this.subtypes = Collections.singletonList(AttackSubType.PIERCE);
        this.characteristics = Collections.emptyList();
    }

    @Override
    public double calculateSpeed() {
        if (MonsterHunter.WEAPON_GREAT_SWORD.equalsIgnoreCase(owner.getSelfStatus()) ||
                MonsterHunter.WEAPON_GUNLANCE.equalsIgnoreCase(owner.getSelfStatus()) ||
                MonsterHunter.WEAPON_HAMMER.equalsIgnoreCase(owner.getSelfStatus())) {
            return super.calculateSpeed() + 5;
        }

        return super.calculateSpeed();
    }

    @Override
    public double getStunChance(Fighter defender, boolean isCrit) {
        if (isCrit) {
            return 1;
        }

        return super.getStunChance(defender, false);
    }

    @Override
    public DamageReport doAttack(Fighter defender) {
        if (MonsterHunter.WEAPON_GREAT_SWORD.equalsIgnoreCase(owner.getSelfStatus()) ||
                MonsterHunter.WEAPON_GUNLANCE.equalsIgnoreCase(owner.getSelfStatus()) ||
                MonsterHunter.WEAPON_HAMMER.equalsIgnoreCase(owner.getSelfStatus())) {
            owner.setSelfStatus(MonsterHunter.WEAPON_BOWGUN);
        }

        return super.doAttack(defender);
    }
}
