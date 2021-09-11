package com.argentstew.simulator.battle.vg.terra;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MagicAttack;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;
import com.argentstew.simulator.battle.status.StatusEffect;
import com.argentstew.simulator.battle.status.StatusType;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.terra
 * 8/27/2019
 *
 * @author Craig
 */
public class Poison extends MagicAttack {

    private static final String LEVEL1 = "Poison";
    private static final String LEVEL2 = "Poisona";
    private static final String LEVEL3 = "Poisonga";

    public Poison() {
        super();
        this.name = LEVEL1;
        this.description = "Has three levels of power, upgrading with each hit; applies poison on hit with turn count varying by power";
        this.power = 10;
        this.variance = 2;
        this.speed = 2;
        this.subtypes = Collections.singletonList(AttackSubType.TOXIC);
        this.characteristics = Collections.emptyList();
    }

    @Override
    public DamageReport doAttack(Fighter defender) {
        DamageReport damageReport = super.doAttack(defender);

        if (!damageReport.isMiss()) {
            if (LEVEL1.equals(name)) {
                defender.setStatus(new StatusEffect(StatusType.POISON, 2));
                name = LEVEL2;
                power = 20;
                variance = 3;
            } else if (LEVEL2.equals(name)) {
                defender.setStatus(new StatusEffect(StatusType.POISON, 3));
                name = LEVEL3;
                power = 30;
                variance = 5;
            } else if (LEVEL3.equals(name)) {
                defender.setStatus(new StatusEffect(StatusType.POISON, 4));
            }
        }

        return damageReport;
    }

    @Override
    public String getBaseName() {
        return LEVEL1;
    }
}
