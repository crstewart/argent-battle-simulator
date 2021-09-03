package com.argentstew.simulator.battle.vg.illidan;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;
import com.argentstew.simulator.battle.trait.impl.DemonicForm;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.illidan
 * 8/27/2019
 *
 * @author Craig
 */
public class DarkBarrage extends MeleeAttack {

    public DarkBarrage() {
        super();
        this.name = "Dark Barrage";
        this.description = "Usable while not in demon form";
        this.power = 70;
        this.variance = 10;
        this.speed = 2.5;
        this.subtypes = Collections.singletonList(AttackSubType.DARK);
        this.characteristics = Collections.emptyList();
    }

    @Override
    public boolean isDoable() {
        return !DemonicForm.DEMONIC_FORM_ENABLED_STATUS.equals(owner.getSelfStatus());
    }
}
