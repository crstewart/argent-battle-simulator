package com.argentstew.simulator.battle.vg.steve;

import com.argentstew.simulator.battle.action.AttackAction;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;
import com.argentstew.simulator.battle.action.defense.Guard;

/**
 * com.argentstew.simulator.battle.vg.steve
 * 8/27/2019
 *
 * @author Craig
 */
public class BuildTerrain extends Guard {

    public BuildTerrain() {
        this.name = "Build Terrain";
        this.initiateMessage = "builds a wall in front of him!";
        this.successMessage = "blocked the attack!";
        this.failureMessage = "failed to block the attack!";
        this.speed = 1.5;
    }

    @Override
    protected boolean doesGuardAttack(AttackAction attack) {
        return !(attack.getSubtypes().contains(AttackSubType.EXPLOSIVE));
    }

    @Override
    public int applyDefense(int damage) {
        return 0;
    }

    @Override
    public AttackAction doCounterAttack(AttackAction attack, int damage) {
        return null;
    }

    @Override
    public boolean isDoable() {
        return true;
    }
}
