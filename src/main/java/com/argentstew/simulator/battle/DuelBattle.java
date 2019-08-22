package com.argentstew.simulator.battle;

import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.reporting.DamageReport;
import lombok.AllArgsConstructor;

/**
 * com.argentstew.simulator.battle
 * 8/21/2019
 *
 * @author Craig
 */
@AllArgsConstructor
public class DuelBattle implements Battle {

    private Fighter fighter1;
    private Fighter fighter2;

    @Override
    public void announce() {
        System.out.println(fighter1 + " enters!");
        System.out.println(fighter2 + " enters!");
        System.out.println("FIGHT!");
    }

    @Override
    public void start() {
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
    }

    @Override
    public void determineWinner() {
        if (fighter1.getHp() > 0) {
            System.out.println(fighter1.getName() + " wins!");
        } else {
            System.out.println(fighter2.getName() + " wins!");
        }
    }
}
