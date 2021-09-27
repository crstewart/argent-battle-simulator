package com.argentstew.simulator.battle.vg.palutena;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MagicAttack;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.palutena
 * 8/27/2019
 *
 * @author Craig
 */
public class BlackHole extends MagicAttack {

    private static final int EQUIP_COST = 7;

    private boolean used = false;

    public BlackHole() {
        super();
        this.name = "Black Hole";
        this.power = 70;
        this.variance = 6;
        this.speed = 2;
        this.subtypes = Collections.singletonList(AttackSubType.GRAVITY);
        this.characteristics = Collections.singletonList(AttackCharacteristic.HOLD);
    }

    @Override
    public DamageReport doAttack(Fighter defender) {
        if (!used) {
            used = true;
            owner.restoreMagic(EQUIP_COST);
        }

        return super.doAttack(defender);
    }

    @Override
    public boolean isAllowed() {
        return used || owner.getMp() + EQUIP_COST <= owner.getMaxMp();
    }
}
