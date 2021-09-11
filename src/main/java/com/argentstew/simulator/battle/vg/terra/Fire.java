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
public class Fire extends MagicAttack {

    private static final String LEVEL1 = "Fire";
    private static final String LEVEL2 = "Fira";
    private static final String LEVEL3 = "Firaga";

    public Fire() {
        super();
        this.name = LEVEL1;
        this.description = "Has three levels of power, upgrading with each hit";
        this.power = 40;
        this.variance = 4;
        this.speed = 1;
        this.subtypes = Collections.singletonList(AttackSubType.FIRE);
        this.characteristics = Collections.emptyList();
    }

    @Override
    public DamageReport doAttack(Fighter defender) {
        DamageReport damageReport = super.doAttack(defender);

        if (!damageReport.isMiss()) {
            if (LEVEL1.equals(name)) {
                name = LEVEL2;
                power = 70;
                variance = 7;
            } else if (LEVEL2.equals(name)) {
                name = LEVEL3;
                power = 100;
                variance = 10;
            }
        }

        return damageReport;
    }

    @Override
    public String getBaseName() {
        return LEVEL1;
    }
}
