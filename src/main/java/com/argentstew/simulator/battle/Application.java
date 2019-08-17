package com.argentstew.simulator.battle;

import com.argentstew.simulator.battle.fighter.Fighter;

/**
 * com.argentstew.simulator.battle
 * 8/17/2019
 *
 * @author Craig
 */
public class Application {

    public static void main(String[] args) {

        Fighter fighter1 = new Fighter("Fighter 1", 100);
        Fighter fighter2 = new Fighter("Fighter 2", 100);

        System.out.println(fighter1 + " enters!");
        System.out.println(fighter2 + " enters!");
        System.out.println("FIGHT!");

        while (fighter1.getHp() > 0 && fighter2.getHp() > 0) {
            fighter1.attack(fighter2);
            System.out.println(fighter1.getName() + " attacks " + fighter2.getName() + "!");
            System.out.println(fighter2);
            if (fighter2.getHp() > 0) {
                fighter2.attack(fighter1);
                System.out.println(fighter2.getName() + " attacks " + fighter1.getName() + "!");
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
