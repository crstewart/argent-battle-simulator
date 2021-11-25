package com.argentstew.simulator.battle.vg.monsterhunter;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.monsterhunter
 * 8/24/2019
 *
 * @author Craig
 */
public class Lance extends MeleeAttack {

    public Lance() {
        super();
        this.name = "Lance";
        this.description = "Reduces priority by 5 to equip; reduces power by 15 after a successful hit (min 30)";
        this.power = 60;
        this.variance = 6;
        this.speed = 1.5;
        this.subtypes = Collections.singletonList(AttackSubType.PIERCE);
        this.characteristics = Collections.emptyList();
    }

    @Override
    public double calculateSpeed() {
        if (MonsterHunter.WEAPON_GREAT_SWORD.equalsIgnoreCase(owner.getSelfStatus()) ||
                MonsterHunter.WEAPON_HAMMER.equalsIgnoreCase(owner.getSelfStatus()) ||
                MonsterHunter.WEAPON_BOWGUN.equalsIgnoreCase(owner.getSelfStatus())) {
            return super.calculateSpeed() + 5;
        }

        return super.calculateSpeed();
    }

    @Override
    public DamageReport doAttack(Fighter defender) {
        if (MonsterHunter.WEAPON_GREAT_SWORD.equalsIgnoreCase(owner.getSelfStatus()) ||
                MonsterHunter.WEAPON_HAMMER.equalsIgnoreCase(owner.getSelfStatus()) ||
                MonsterHunter.WEAPON_BOWGUN.equalsIgnoreCase(owner.getSelfStatus())) {
            owner.setSelfStatus(MonsterHunter.WEAPON_GUNLANCE);
        }

        DamageReport report = super.doAttack(defender);
        this.power = Math.max(30, this.power - 15);

        return report;
    }
}
