package com.argentstew.simulator.battle.vg.terra;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.AttackType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.action.move.Sleep;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.BalancedStrategy;
import com.argentstew.simulator.battle.trait.impl.Rival;
import com.argentstew.simulator.battle.vg.kefka.Kefka;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.terra
 * 8/27/2019
 *
 * @author Craig
 */
public class TerraBranford {

    public static final String NAME = "Terra Branford";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackType.MAGIC, 0.6);
        defenses.set(AttackSubType.GRAVITY, 0.95);

        FighterStats stats = FighterStats.builder().strength(4).toughness(2).dexterity(5).aim(7)
                .agility(4.5).speed(4).intellect(7.5).willpower(5).size(4.5).weight(4.5).build();
        FighterTraits traits = new FighterTraits(Collections.singletonList(new Rival(Kefka.NAME, 1.3)));
        return Fighter.builder().name(NAME).hp(140).maxHp(140).xStrikeMeter(0)
                .description("A mage with spells that upgrade over the course of a battle.")
                .entryQuotes(Arrays.asList("Terra: 'What am I feeling? What's going on?'",
                        "Terra: 'The fate of the world rests on my shoulders.'"))
                .victoryQuotes(Arrays.asList("Terra: 'I now realize that we must fight for the future of our children.'",
                        "Terra: 'Why do you continue to fight?'"))
                .classifications(Arrays.asList(FighterClassification.HUMANOID, FighterClassification.MONSTER))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new BalancedStrategy()).build()
                .addAction(new RiotBlade()).addAction(new Fire()).addAction(new Poison())
                .addAction(new Gravity()).addAction(new Cure())
                .addAction(new TranceUltima())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat()).addAction(new Sleep());
    }
}
