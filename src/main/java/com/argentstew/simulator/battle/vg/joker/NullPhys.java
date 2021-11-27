package com.argentstew.simulator.battle.vg.joker;

import com.argentstew.simulator.battle.action.AttackAction;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.defense.Guard;

import java.util.Arrays;
import java.util.List;

/**
 * com.argentstew.simulator.battle.vg.joker
 * 8/27/2019
 *
 * @author Craig
 */
public class NullPhys extends Guard {

    private static final List<AttackSubType> BLOCKABLE_ATTACK_TYPES = Arrays.asList(AttackSubType.PUNCH,
            AttackSubType.KICK, AttackSubType.HEADBUTT, AttackSubType.SLAM, AttackSubType.CLAW,
            AttackSubType.BITE, AttackSubType.TAIL, AttackSubType.WING, AttackSubType.SLASH,
            AttackSubType.PIERCE, AttackSubType.HACK, AttackSubType.SMASH, AttackSubType.HANDGUN,
            AttackSubType.SHOTGUN, AttackSubType.RIFLE, AttackSubType.GRAPPLE);

    public NullPhys() {
        this.name = "Null Phys";
        this.description = "Blocks all physical attacks";
        this.initiateMessage = "calls forth Izanagi to prepare a defense!";
        this.successMessage = "successfully defended the attack!";
        this.failureMessage = "failed to defend the attack!";
        this.speed = 0.5;
    }

    @Override
    protected boolean doesGuardAttack(AttackAction attack) {
        return attack.getSubtypes().stream().anyMatch(BLOCKABLE_ATTACK_TYPES::contains);
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
    public boolean isAllowed() {
        return Joker.PERSONA_IZANAGI.equals(owner.getSelfStatus());
    }
}
