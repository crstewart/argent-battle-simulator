package com.argentstew.simulator.battle;

import com.argentstew.simulator.battle.action.AttackAction;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.fighter.FighterVariance;

/**
 * com.argentstew.simulator.battle
 * 8/17/2019
 *
 * @author Craig
 */
public class Application {

    public static void main(String[] args) {

        Fighter fighter1 = Fighter.builder().name("Fighter 1").maxHp(100).hp(100)
                .variance(FighterVariance.builder().critChance(0.2).damageVariance(10).build())
                .build();
        Fighter fighter2 = Fighter.builder().name("Fighter 2").maxHp(100).hp(100)
                .variance(FighterVariance.builder().critChance(0.2).damageVariance(10).build())
                .build();

        System.out.println(fighter1 + " enters!");
        System.out.println(fighter2 + " enters!");
        System.out.println("FIGHT!");

        while (fighter1.getHp() > 0 && fighter2.getHp() > 0) {
            AttackAction attack = fighter1.attack();
            System.out.println(fighter1.getName() + " attacks " + fighter2.getName() + " for " + attack.getDamage() + " damage!");
            if (attack.isCrit()) {
                System.out.println("CRITICAL HIT!");
            }
            fighter2.takeDamage(attack);
            System.out.println(fighter2);

            if (fighter2.getHp() > 0) {
                AttackAction attack2 = fighter2.attack();
                System.out.println(fighter2.getName() + " attacks " + fighter1.getName() + " for " + attack2.getDamage() + " damage!");
                if (attack2.isCrit()) {
                    System.out.println("CRITICAL HIT!");
                }
                fighter1.takeDamage(attack2);
                System.out.println(fighter1);
            }
        }

        if (fighter1.getHp() > 0) {
            System.out.println(fighter1.getName() + " wins!");
        } else {
            System.out.println(fighter2.getName() + " wins!");
        }
    }
}
