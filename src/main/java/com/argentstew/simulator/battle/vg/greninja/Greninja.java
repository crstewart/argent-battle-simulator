package com.argentstew.simulator.battle.vg.greninja;

import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.BalancedStrategy;
import com.argentstew.simulator.battle.strategy.DefensiveStrategy;
import com.argentstew.simulator.battle.trait.impl.NaturalAgility;
import com.argentstew.simulator.battle.trait.impl.Protean;

import java.util.Arrays;

/**
 * com.argentstew.simulator.battle.vg.greninja
 * 9/7/2019
 *
 * @author Craig
 */
public class Greninja {

    public static final String NAME = "Greninja";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();

        FighterStats stats = FighterStats.builder().strength(6).toughness(3).dexterity(7).aim(7)
                .agility(8).speed(8).intellect(3.5).willpower(7).size(3.5).weight(3).build();
        FighterTraits traits = new FighterTraits(Arrays.asList(new Protean(), new NaturalAgility()));
        return Fighter.builder().name(NAME).hp(150).maxHp(150).xStrikeMeter(0)
                .description("A speedy fighter whose weaknesses and resistances change over the course of battle.")
                .entryQuotes(Arrays.asList("Greninja: 'Ninja!'", "Greninja: 'Grenin...'"))
                .victoryQuotes(Arrays.asList("Greninja: 'Ja ja ja ja ja!'", "Greninja: 'Nin-JA!'"))
                .classifications(Arrays.asList(FighterClassification.ANIMAL, FighterClassification.MONSTER))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new BalancedStrategy()).build()
                .addAction(new WaterShuriken()).addAction(new ShadowSneak()).addAction(new NightSlash())
                .addAction(new MatBlock())
                .addAction(new SecretNinjaTechnique())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
    }
}
