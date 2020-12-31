package com.argentstew.simulator.battle.vg.zelda;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.AttackType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.BalancedStrategy;
import com.argentstew.simulator.battle.strategy.OffensiveStrategy;
import com.argentstew.simulator.battle.trait.impl.Hazardous;
import com.argentstew.simulator.battle.trait.impl.Rival;
import com.argentstew.simulator.battle.vg.ganondorf.Ganondorf;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.zelda
 * 8/27/2019
 *
 * @author Craig
 */
public class Zelda {

    public static final String NAME = "Zelda";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackType.MAGIC, 0.6);

        FighterStats stats = FighterStats.builder().strength(3.5).toughness(3).dexterity(7).aim(8)
                .agility(5).speed(4).intellect(8).willpower(8).size(4.5).weight(4.5).build();
        FighterTraits traits = new FighterTraits();
        return Fighter.builder().name(NAME).hp(140).maxHp(140).xStrikeMeter(0)
                .description("A mage with a reflective guard and strong magic abilities.")
                .entryQuotes(Arrays.asList("Zelda: 'I will deal with Hyrule's enemies myself!'",
                        "Zelda: 'Stow your fear; it's now or never!'"))
                .victoryQuotes(Arrays.asList("Zelda: 'Victory is ours on this day!'",
                        "Zelda: 'All shadows must eventually meet the light.'"))
                .classifications(Collections.singletonList(FighterClassification.HUMANOID))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new BalancedStrategy()).build()
                .addAction(new ArrowOfLight()).addAction(new DinsFire()).addAction(new FaroresWind())
                .addAction(new NayrusLove())
                .addAction(new SagesSeal())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
    }
}
