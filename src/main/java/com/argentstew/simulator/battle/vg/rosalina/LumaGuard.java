package com.argentstew.simulator.battle.vg.rosalina;

import com.argentstew.simulator.battle.action.AttackAction;
import com.argentstew.simulator.battle.action.defense.Guard;
import com.argentstew.simulator.battle.trait.impl.StarGuidance;

/**
 * com.argentstew.simulator.battle.vg.rosalina
 * 8/24/2019
 *
 * @author Craig
 */
public class LumaGuard extends Guard {

    public LumaGuard() {
        this.name = "Luma Guard";
        this.description = "Uses the currently summoned Luma to block the attack; Luma has 40 HP, " +
                "takes double damage from attacks, and needs 3 turns to respawn";
        this.initiateMessage = "calls upon her Luma to aid her!";
        this.successMessage = "successfully defended the attack!";
        this.failureMessage = "failed to block the attack!";
        this.speed = 0.5;
    }

    @Override
    public int applyDefense(int damage) {
        StarGuidance starGuidance = owner.getTraits().getTrait(StarGuidance.class);
        if (starGuidance != null) {
            starGuidance.blockDamage(damage);
            return 0;
        }

        return damage;
    }

    @Override
    public AttackAction doCounterAttack(AttackAction attack, int damage) {
        return null;
    }

    @Override
    public boolean isAllowed() {
        StarGuidance starGuidance = owner.getTraits().getTrait(StarGuidance.class);
        if (starGuidance != null) {
            return starGuidance.isReady();
        }

        return false;
    }

    @Override
    protected boolean doesGuardAttack(AttackAction attack) {
        return true;
    }
}
