package com.argentstew.simulator.battle.vg.diablo;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.AttackType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.BalancedStrategy;
import com.argentstew.simulator.battle.strategy.OffensiveStrategy;
import com.argentstew.simulator.battle.vg.arthas.*;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.diablo
 * 4/4/2020
 *
 * @author argen
 */
public class Diablo {

    public static final String NAME = "Diablo";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackSubType.LIGHT, 1.4);
        defenses.set(AttackSubType.DARK, 0.6);

        FighterStats stats = FighterStats.builder().strength(7.5).toughness(8.5).dexterity(3.5).aim(4.5)
                .agility(3.5).speed(4).intellect(4).willpower(8.5).size(7).weight(7).build();
        FighterTraits traits = new FighterTraits();
        return Fighter.builder().name(NAME).hp(220).maxHp(220).xStrikeMeter(0)
                .description("A tank who can shrug off almost any attack.")
                .entryQuotes(Arrays.asList("Diablo: 'Kneel before the Lord of Terror.'", "Diablo: 'I will feast upon your terror!'"))
                .victoryQuotes(Arrays.asList("Diablo: 'Not even death can save you from me!'",
                        "Diablo: 'You have failed. Your soul is mine!'"))
                .classifications(Collections.singletonList(FighterClassification.DEMONIC))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new OffensiveStrategy()).build()
                .addAction(new FireStomp()).addAction(new FireClaws()).addAction(new Overpower())
                .addAction(new Apocalypse())
                .addAction(new LightningBreath())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
    }
}
