package com.argentstew.simulator.battle.vg.guybrush;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.AttackType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.OffensiveStrategy;
import com.argentstew.simulator.battle.vg.cuphead.*;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.guybrush
 * 4/10/2020
 *
 * @author argen
 */
public class GuybrushThreepwood {

    public static final String NAME = "Guybrush Threepwood";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackType.MAGIC, 0.9);
        defenses.set(AttackSubType.PLASMA, 1.2);

        FighterStats stats = FighterStats.builder().strength(4.5).toughness(4).dexterity(8).aim(7.5)
                .agility(5.5).speed(5).intellect(5.5).willpower(6).size(5).weight(5).build();
        FighterTraits traits = new FighterTraits();
        return Fighter.builder().name(NAME).hp(150).maxHp(150).mp(0).maxMp(0).xStrikeMeter(0)
                .description("A pirate weaponmaster who comes from a world of voodoo magic.")
                .entryQuotes(Arrays.asList("Guybrush: 'I'm Guybrush Threepwood, Mighty Pirate™!'",
                        "Guybrush: 'I love the smell of treasure in the morning.'"))
                .victoryQuotes(Arrays.asList("Guybrush: 'You fight like a dairy farmer!'",
                        "Guybrush: 'Treasure? You wanted treasure? I'm sorry, I'm fresh out.'"))
                .classifications(Collections.singletonList(FighterClassification.HUMANOID))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new OffensiveStrategy()).build()
                .addAction(new Cutlass()).addAction(new Pistol()).addAction(new VoodooDoll())
                .addAction(new RootBeer())
                .addAction(new DestructomaticT47())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
    }
}
