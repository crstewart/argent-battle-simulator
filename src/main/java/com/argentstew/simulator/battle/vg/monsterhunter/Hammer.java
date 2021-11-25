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
public class Hammer extends MeleeAttack {

    public Hammer() {
        super();
        this.name = "Hammer";
        this.description = "Reduces priority by 5 to equip; reduces power by 20 after a successful hit (min 30)";
        this.power = 70;
        this.variance = 6;
        this.speed = 2;
        this.subtypes = Collections.singletonList(AttackSubType.SMASH);
        this.characteristics = Collections.emptyList();
    }

    @Override
    public double calculateSpeed() {
        if (MonsterHunter.WEAPON_GREAT_SWORD.equalsIgnoreCase(owner.getSelfStatus()) ||
                MonsterHunter.WEAPON_GUNLANCE.equalsIgnoreCase(owner.getSelfStatus()) ||
                MonsterHunter.WEAPON_BOWGUN.equalsIgnoreCase(owner.getSelfStatus())) {
            return super.calculateSpeed() + 5;
        }

        return super.calculateSpeed();
    }

    @Override
    public DamageReport doAttack(Fighter defender) {
        if (MonsterHunter.WEAPON_GREAT_SWORD.equalsIgnoreCase(owner.getSelfStatus()) ||
                MonsterHunter.WEAPON_GUNLANCE.equalsIgnoreCase(owner.getSelfStatus()) ||
                MonsterHunter.WEAPON_BOWGUN.equalsIgnoreCase(owner.getSelfStatus())) {
            owner.setSelfStatus(MonsterHunter.WEAPON_HAMMER);
        }

        DamageReport report = super.doAttack(defender);
        this.power = Math.max(30, this.power - 20);

        return report;
    }
}
