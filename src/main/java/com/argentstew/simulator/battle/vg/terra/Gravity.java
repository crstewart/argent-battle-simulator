package com.argentstew.simulator.battle.vg.terra;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MagicAttack;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.terra
 * 8/27/2019
 *
 * @author Craig
 */
public class Gravity extends MagicAttack {

    private static final String LEVEL1 = "Gravity";
    private static final String LEVEL2 = "Graviga";
    private static final String LEVEL3 = "Gravija";

    public Gravity() {
        super();
        this.name = LEVEL1;
        this.description = "Has three levels of power, upgrading with each hit";
        this.power = 60;
        this.variance = 7;
        this.speed = 1.5;
        this.subtypes = Collections.singletonList(AttackSubType.GRAVITY);
        this.characteristics = Collections.emptyList();
    }

    @Override
    public DamageReport doAttack(Fighter defender) {
        DamageReport damageReport = super.doAttack(defender);

        if (!damageReport.isMiss()) {
            if (LEVEL1.equals(name)) {
                name = LEVEL2;
                power = 90;
                variance = 10;
            } else if (LEVEL2.equals(name)) {
                name = LEVEL3;
                power = 140;
                variance = 15;
            }
        }

        return damageReport;
    }

    @Override
    public String getBaseName() {
        return LEVEL1;
    }
}
