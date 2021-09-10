package com.argentstew.simulator.battle.vg.illidan;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MagicAttack;
import com.argentstew.simulator.battle.trait.impl.DemonHeart;

import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.illidan
 * 8/27/2019
 *
 * @author Craig
 */
public class ShadowBlast extends MagicAttack {

    public ShadowBlast() {
        super();
        this.name = "Shadow Blast";
        this.description = "Usable only while in demon form";
        this.power = 100;
        this.variance = 8;
        this.speed = 2.5;
        this.subtypes = Collections.singletonList(AttackSubType.DARK);
        this.characteristics = Collections.emptyList();
    }

    @Override
    public boolean isDoable() {
        return super.isDoable() && DemonHeart.DEMONIC_FORM_ENABLED_STATUS.equals(owner.getSelfStatus());
    }
}
