package com.argentstew.simulator.battle.vg.samfisher;

import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.BalancedStrategy;
import com.argentstew.simulator.battle.trait.impl.StealthDetection;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.samfisher
 * 4/5/2020
 *
 * @author argen
 */
public class SamFisher {

    public static final String NAME = "Sam Fisher";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();

        FighterStats stats = FighterStats.builder().strength(6).toughness(5.5).dexterity(6).aim(6.5)
                .agility(5.5).speed(5).intellect(5.5).willpower(5).size(5).weight(5).build();
        FighterTraits traits = new FighterTraits(Collections.singletonList(new StealthDetection()));
        return Fighter.builder().name(NAME).hp(150).maxHp(150).xStrikeMeter(0)
                .description("An all-around fighter specializing in the art of stealth.")
                .entryQuotes(Arrays.asList("Sam Fisher: 'Look what we have here.'",
                        "Sam Fisher: 'This doesn't have to hurt too much.'"))
                .victoryQuotes(Arrays.asList("Sam Fisher: 'Hey, it's not like Grim is paying me by the hour.'",
                        "Sam Fisher: 'There are times to stay calm, this isn't one of them.'"))
                .classifications(Collections.singletonList(FighterClassification.HUMANOID))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new BalancedStrategy()).build()
                .addAction(new FiveSeven()).addAction(new Mossberg500()).addAction(new PanthersClaw())
                .addAction(new KravMaga()).addAction(new StealthTakedown())
                .addAction(new SC20KMAWS())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
    }
}
