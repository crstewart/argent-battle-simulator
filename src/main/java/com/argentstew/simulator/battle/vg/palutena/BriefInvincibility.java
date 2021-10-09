package com.argentstew.simulator.battle.vg.palutena;

import com.argentstew.simulator.battle.action.AttackAction;
import com.argentstew.simulator.battle.action.defense.Guard;

/**
 * com.argentstew.simulator.battle.vg.palutena
 * 8/27/2019
 *
 * @author Craig
 */
public class BriefInvincibility extends Guard {

    private static final int EQUIP_COST = 6;

    private boolean used = false;

    public BriefInvincibility() {
        this.name = "Brief Invicibility";
        this.description = "Costs 6 SP to equip; blocks all effects of fast attacks";
        this.initiateMessage = "becomes invincible!";
        this.successMessage = "negates the attack!";
        this.failureMessage = "failed to defend the attack!";
        this.speed = 0;
    }

    @Override
    protected boolean doesGuardAttack(AttackAction attack) {
        return attack.getSpeed() < 2;
    }

    @Override
    public int applyDefense(int damage) {
        if (!used) {
            used = true;
            owner.useMagic(EQUIP_COST);
        }

        return 0;
    }

    @Override
    public AttackAction doCounterAttack(AttackAction attack, int damage) {
        return null;
    }

    @Override
    public boolean isAllowed() {
        return used || owner.getMp() >= EQUIP_COST;
    }
}
