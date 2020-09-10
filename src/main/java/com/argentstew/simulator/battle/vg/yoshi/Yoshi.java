package com.argentstew.simulator.battle.vg.yoshi;

import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.BalancedStrategy;
import com.argentstew.simulator.battle.trait.impl.StealthDetection;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.yoshi
 * 8/26/2019
 *
 * @author Craig
 */
public class Yoshi {

    public static final String NAME = "Yoshi";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();

        FighterStats stats = FighterStats.builder().strength(5).toughness(5.5).dexterity(4.5).aim(9)
                .agility(6.5).speed(6).intellect(3).willpower(8).size(4).weight(4).build();
        FighterTraits traits = new FighterTraits(Collections.singletonList(new StealthDetection()));
        return Fighter.builder().name(NAME).hp(160).maxHp(160).xStrikeMeter(0)
                .description("An all-around fighter who is accurate at range but not in melee combat.")
                .entryQuotes(Arrays.asList("Yoshi: 'Yoshi!'",
                        "Yoshi pops out of an egg and faces his opponent."))
                .victoryQuotes(Arrays.asList("Yoshi spins around and gives the V sign.", "Yoshi: 'Wow!'"))
                .classifications(Arrays.asList(FighterClassification.ANIMAL, FighterClassification.DRAGON))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new BalancedStrategy()).build()
                .addAction(new EggToss()).addAction(new EggLay()).addAction(new GroundPound())
                .addAction(new FlutterKick()).addAction(new EggShield())
                .addAction(new MegaEggdozer())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
    }
}
