package com.argentstew.simulator.battle.vg.slycooper;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.BalancedStrategy;
import com.argentstew.simulator.battle.strategy.DefensiveStrategy;
import com.argentstew.simulator.battle.vg.cole.*;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.slycooper
 * 4/3/2020
 *
 * @author argen
 */
public class SlyCooper {

    public static final String NAME = "Sly Cooper";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();

        FighterStats stats = FighterStats.builder().strength(4).toughness(3).dexterity(9.5).aim(5)
                .agility(9).speed(6.5).intellect(6.5).willpower(5).size(5).weight(4.5).build();
        FighterTraits traits = new FighterTraits();
        return Fighter.builder().name(NAME).hp(140).maxHp(140).xStrikeMeter(0)
                .description("A speedy fighter who dodges attacks and strikes quickly.")
                .entryQuotes(Arrays.asList("Sly: 'I haven't stolen anything...yet.'",
                        "Sly: 'I'm on the job!'"))
                .victoryQuotes(Arrays.asList("Sly: 'Better check your pocket every now and then!'",
                        "Sly: 'Don't make yourself too comfortable around me now.'"))
                .classifications(Collections.singletonList(FighterClassification.ANIMAL))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new DefensiveStrategy()).build()
                .addAction(new CaneSwipe()).addAction(new CaneStun()).addAction(new RaccoonRoll())
                .addAction(new ShadowPower())
                .addAction(new CooperGangAssault())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
    }
}
