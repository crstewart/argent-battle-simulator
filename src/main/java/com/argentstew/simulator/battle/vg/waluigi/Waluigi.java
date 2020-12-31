package com.argentstew.simulator.battle.vg.waluigi;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.BalancedStrategy;
import com.argentstew.simulator.battle.strategy.OffensiveStrategy;
import com.argentstew.simulator.battle.trait.impl.Cheater;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.waluigi
 * 8/26/2019
 *
 * @author Craig
 */
public class Waluigi {

    public static final String NAME = "Waluigi";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackSubType.WATER, 0.7);
        defenses.set(AttackSubType.TOXIC, 0.8);

        FighterStats stats = FighterStats.builder().strength(4.5).toughness(4).dexterity(5).aim(5)
                .agility(8).speed(6).intellect(5).willpower(6).size(4.5).weight(4).build();
        FighterTraits traits = new FighterTraits(Collections.singletonList(new Cheater()));
        return Fighter.builder().name(NAME).hp(140).maxHp(140).xStrikeMeter(0)
                .description("A speedy fighter that has the tendency to cheat his way to victory.")
                .entryQuotes(Arrays.asList("Waluigi: 'Waluigi time!'", "Waluigi: 'Heh heh heh! I got it.'"))
                .victoryQuotes(Arrays.asList("Waluigi: 'Wah, heh, heh, heh! Waluigi is number one!'",
                        "Waluigi: 'Yeah! Waluigi's the winner!'"))
                .classifications(Collections.singletonList(FighterClassification.HUMANOID))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new BalancedStrategy()).build()
                .addAction(new TennisRacket()).addAction(new Stomp()).addAction(new PirahnaPlant())
                .addAction(new BobombThrow())
                .addAction(new MasterOfTheDance())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
    }
}
