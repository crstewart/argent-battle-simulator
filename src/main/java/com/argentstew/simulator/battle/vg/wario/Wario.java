package com.argentstew.simulator.battle.vg.wario;

import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.BalancedStrategy;
import com.argentstew.simulator.battle.strategy.OffensiveStrategy;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.wario
 * 8/27/2019
 *
 * @author Craig
 */
public class Wario {

    public static final String NAME = "Wario";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();

        FighterStats stats = FighterStats.builder().strength(6.5).toughness(6).dexterity(3).aim(5)
                .agility(3).speed(3.5).intellect(5).willpower(6).size(4).weight(5).build();
        FighterTraits traits = new FighterTraits();
        return Fighter.builder().name(NAME).hp(170).maxHp(170).xStrikeMeter(0)
                .description("A tank with a single-use ranged attack that fights aggressively in melee.")
                .entryQuotes(Arrays.asList("Wario: 'I'm-a Wario, I'm-a gonna win!'",
                        "Wario: 'Hey! Look here! It's Wario.'"))
                .victoryQuotes(Arrays.asList("Wario: 'Yeah! Take that losers! Heh heh heh!'",
                        "Wario: 'Wario always win!'"))
                .classifications(Collections.singletonList(FighterClassification.HUMANOID))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new OffensiveStrategy()).build()
                .addAction(new ShoulderCharge()).addAction(new CorkscrewConk()).addAction(new BobombThrow())
                .addAction(new Chomp())
                .addAction(new WarioWaft())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
    }
}
