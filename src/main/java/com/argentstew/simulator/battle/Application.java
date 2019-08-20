package com.argentstew.simulator.battle;

import com.argentstew.simulator.battle.action.AttackAction;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.fighter.FighterVariance;
import com.argentstew.simulator.battle.reporting.DamageReport;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle
 * 8/17/2019
 *
 * @author Craig
 */
public class Application {

    public static void main(String[] args) {

        Fighter fighter1 = Fighter.builder().name("Fighter 1").maxHp(100).hp(100)
                .actions(Collections.singletonList(AttackAction.builder().name("Punch").power(5).variance(10).build()))
                .build();
        Fighter fighter2 = Fighter.builder().name("Fighter 2").maxHp(100).hp(100)
                .actions(Collections.singletonList(AttackAction.builder().name("Punch").power(5).variance(10).build()))
                .build();

        System.out.println(fighter1 + " enters!");
        System.out.println(fighter2 + " enters!");
        System.out.println("FIGHT!");

        while (fighter1.getHp() > 0 && fighter2.getHp() > 0) {
            DamageReport report = fighter1.attack();
            System.out.println(fighter1.getName() + " attacks " + fighter2.getName() + " with " + report.getAttack().getName() + " for " + report.getDamage() + " damage!");
            if (report.isCrit()) {
                System.out.println("CRITICAL HIT!");
            }
            fighter2.takeDamage(report);
            System.out.println(fighter2);

            if (fighter2.getHp() > 0) {
                DamageReport report2 = fighter2.attack();
                System.out.println(fighter2.getName() + " attacks " + fighter1.getName() + " with " + report.getAttack().getName() + " for " + report2.getDamage() + " damage!");
                if (report2.isCrit()) {
                    System.out.println("CRITICAL HIT!");
                }
                fighter1.takeDamage(report2);
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
