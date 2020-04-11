package com.argentstew.simulator.battle.vg.ganondorf;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
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
 * com.argentstew.simulator.battle.vg.ganondorf
 * 8/27/2019
 *
 * @author Craig
 */
public class Ganondorf {

    public static final String NAME = "Ganondorf";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackType.MAGIC, 0.8);
        defenses.set(AttackSubType.LIGHT, 1.25);
        defenses.set(AttackSubType.DARK, 1.1);

        FighterStats stats = FighterStats.builder().strength(6.5).toughness(5.5).dexterity(4).aim(5)
                .agility(4).speed(3.5).intellect(6.5).willpower(7.5).size(5).weight(5).build();
        FighterTraits traits = new FighterTraits();
        return Fighter.builder().name(NAME).hp(165).maxHp(165).xStrikeMeter(0)
                .description("A brawler who resists magic with a variety of darkness-infused attacks.")
                .entryQuotes(Arrays.asList("Ganondorf: 'Behold! The power of the Demon King!'",
                        "Ganondorf: 'You want a piece of me?! Very funny! I like your attitude!'"))
                .victoryQuotes(Arrays.asList("Ganondorf: 'I've outlived more \"heroes\" than you can possibly imagine.'",
                        "Ganondorf: 'Pathetic little fool! Do you know who I am?! I am Ganondorf and soon I will rule the world!'"))
                .classifications(Collections.singletonList(FighterClassification.HUMANOID))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new BalancedStrategy()).build()
                .addAction(new MagicOrb()).addAction(new SwordOfDespair()).addAction(new WarlockPunch())
                .addAction(new FlameChoke())
                .addAction(new DarkLordGanon())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
    }
}
