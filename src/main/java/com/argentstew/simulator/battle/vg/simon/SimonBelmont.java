package com.argentstew.simulator.battle.vg.simon;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.AttackType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.BalancedStrategy;
import com.argentstew.simulator.battle.strategy.DefensiveStrategy;
import com.argentstew.simulator.battle.vg.snake.*;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.simon
 * 4/3/2020
 *
 * @author argen
 */
public class SimonBelmont {

    public static final String NAME = "Simon Belmont";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackSubType.DARK, 0.75);

        FighterStats stats = FighterStats.builder().strength(5.5).toughness(6).dexterity(7).aim(7.5)
                .agility(4.5).speed(4).intellect(5).willpower(6).size(5).weight(5).build();
        FighterTraits traits = new FighterTraits();
        return Fighter.builder().name(NAME).hp(150).maxHp(150).mp(10).maxMp(10).xStrikeMeter(0)
                .description("A weaponmaster who wields various light-based attacks.")
                .entryQuotes(Arrays.asList("Simon: 'If you will fight, then stand resolute.'",
                        "Simon: 'I will show you the might of House Belmont.'"))
                .victoryQuotes(Arrays.asList("Simon: 'I vanquish the darkness!'",
                        "Simon: 'Finally, I have my answer. My power is more than just this whip.'"))
                .classifications(Collections.singletonList(FighterClassification.HUMANOID))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new BalancedStrategy()).build()
                .addAction(new VampireKiller()).addAction(new Cross()).addAction(new Axe())
                .addAction(new HolyWater())
                .addAction(new GrandCross())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
    }
}
