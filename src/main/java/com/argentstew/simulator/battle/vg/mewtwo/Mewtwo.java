package com.argentstew.simulator.battle.vg.mewtwo;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.DefensiveStrategy;
import com.argentstew.simulator.battle.trait.impl.NaturalAgility;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.mewtwo
 * 9/15/2019
 *
 * @author Craig
 */
public class Mewtwo {

    public static final String NAME = "Mewtwo";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackSubType.PUNCH, 0.875);
        defenses.set(AttackSubType.KICK, 0.875);
        defenses.set(AttackSubType.DARK, 1.25);
        defenses.set(AttackSubType.NATURE, 1.125);
        defenses.set(AttackSubType.MYSTIC, 0.75);
        defenses.set(AttackSubType.CHI, 0.75);

        FighterStats stats = FighterStats.builder().strength(6).toughness(5.5).dexterity(4).aim(6)
                .agility(8).speed(7).intellect(10).willpower(5).size(5.5).weight(6.5).build();
        FighterTraits traits = new FighterTraits(Collections.singletonList(new NaturalAgility()));
        return Fighter.builder().name(NAME).hp(180).maxHp(180).xStrikeMeter(0)
                .entryQuotes(Arrays.asList("Mewtwo: 'Behold my powers! I am the strongest Pokémon in the world.'",
                        "Mewtwo: 'I will find my own purpose... and purge this planet of all who oppose me!'"))
                .victoryQuotes(Arrays.asList("Mewtwo: 'I am sparing your life, for the moment. But you cannot escape your fate.'",
                        "Mewtwo: 'It is what you do with the gift of life that determines who you are.'"))
                .classifications(Collections.singletonList(FighterClassification.MONSTER))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new DefensiveStrategy()).build()
                .addAction(new Psychic()).addAction(new ShadowBall()).addAction(new Confusion())
                .addAction(new Recover())
                .addAction(new MegaPsystrike())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
    }
}
