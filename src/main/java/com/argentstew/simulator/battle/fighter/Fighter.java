package com.argentstew.simulator.battle.fighter;

import com.argentstew.simulator.battle.action.Action;
import com.argentstew.simulator.battle.action.AttackAction;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * com.argentstew.simulator.battle.fighter
 * 8/17/2019
 *
 * @author Craig
 */
@Data
@Builder
@AllArgsConstructor
public class Fighter {

    private String name;
    private int hp;
    private int maxHp;

    private List<Action> actions;

    private FighterStats stats;
    private FighterTraits traits;
    private FighterVariance variance;

    public AttackAction attack() {
        AttackAction attack = new AttackAction();
        double baseDamage = calculateBaseDamage();
        if (Math.random() <= variance.getCritChance()) {
            attack.setDamage((int) Math.round(baseDamage * 2));
            attack.setCrit(true);
        } else {
            attack.setDamage((int) Math.round(baseDamage));
            attack.setCrit(false);
        }

        return attack;
    }

    public void takeDamage(AttackAction attack) {
        this.hp = (attack.getDamage() > this.hp) ? 0 : this.hp - attack.getDamage();
    }

    private double calculateBaseDamage() {
        int baseAttack = 5;
        double bonusDamage = Math.random() * variance.getDamageVariance();
        return baseAttack + bonusDamage;
    }

    @Override
    public String toString() {
        return name + " (" + hp + "/" + maxHp + ")";
    }
}
