package com.argentstew.simulator.battle.fighter;

import com.argentstew.simulator.battle.action.AttackAction;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * com.argentstew.simulator.battle.fighter
 * 8/17/2019
 *
 * @author Craig
 */
@Data
@AllArgsConstructor
public class Fighter {

    private String name;
    private int hp;
    private int maxHp;
    private double variance;
    private double criticalHitChance;

    public Fighter(String name, int maxHp) {
        this(name, maxHp, maxHp, 10.0, 0.2);
    }

    public Fighter(String name, int maxHp, double variance) {
        this(name, maxHp, maxHp, variance, 0.2);
    }

    public Fighter(String name, int maxHp, double variance, double criticalHitChance) {
        this(name, maxHp, maxHp, variance, criticalHitChance);
    }

    public AttackAction attack() {
        AttackAction attack = new AttackAction();
        double baseDamage = calculateBaseDamage();
        if (Math.random() <= criticalHitChance) {
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
        double bonusDamage = Math.random() * variance;
        return baseAttack + bonusDamage;
    }

    @Override
    public String toString() {
        return name + " (" + hp + "/" + maxHp + ")";
    }
}
