package com.argentstew.simulator.battle.vg.diddykong;

import com.argentstew.simulator.battle.action.attack.AttackType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.BalancedStrategy;
import com.argentstew.simulator.battle.strategy.OffensiveStrategy;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.diddykong
 * 8/26/2019
 *
 * @author Craig
 */
public class DiddyKong {

    public static final String NAME = "Diddy Kong";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();

        FighterStats stats = FighterStats.builder().strength(4).toughness(4).dexterity(8).aim(8)
                .agility(8).speed(6.5).intellect(4).willpower(3.5).size(4).weight(3.5).build();
        FighterTraits traits = new FighterTraits();
        return Fighter.builder().name(NAME).hp(130).maxHp(130).xStrikeMeter(0)
                .entryQuotes(Arrays.asList("Diddy claps his hands and faces his opponent.",
                        "Diddy bursts onto the scene and backflips."))
                .victoryQuotes(Arrays.asList("Diddy tosses his hat into the air and winks.",
                        "Diddy pulls out his popguns and fires off a couple shots in victory."))
                .classifications(Collections.singletonList(FighterClassification.ANIMAL))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new BalancedStrategy()).build()
                .addAction(new PeanutPopgun()).addAction(new BananaPeel()).addAction(new Cartwheel())
                .addAction(new MonkeyFlip())
                .addAction(new HyperRocketbarrel())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
    }
}
