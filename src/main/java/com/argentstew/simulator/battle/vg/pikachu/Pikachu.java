package com.argentstew.simulator.battle.vg.pikachu;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.AttackType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.DefensiveStrategy;
import com.argentstew.simulator.battle.strategy.OffensiveStrategy;
import com.argentstew.simulator.battle.trait.impl.NaturalAgility;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.pikachu
 * 9/7/2019
 *
 * @author Craig
 */
public class Pikachu {

    public static final String NAME = "Pikachu";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackSubType.EARTH, 1.25);
        defenses.set(AttackSubType.THUNDER, 0.75);
        defenses.set(AttackSubType.AIR, 0.75);
        defenses.set(AttackSubType.METAL, 0.75);
        defenses.set(AttackSubType.HANDGUN, 0.875);
        defenses.set(AttackSubType.SHOTGUN, 0.875);
        defenses.set(AttackSubType.RIFLE, 0.875);

        FighterStats stats = FighterStats.builder().strength(2).toughness(4).dexterity(8).aim(8.5)
                .agility(9).speed(8).intellect(3).willpower(5.5).size(2).weight(1.5).build();
        FighterTraits traits = new FighterTraits(Collections.singletonList(new NaturalAgility()));
        return Fighter.builder().name(NAME).hp(125).maxHp(125).xStrikeMeter(0)
                .description("A speedy fighter with strong defenses leading to a powerful X-Strike.")
                .entryQuotes(Arrays.asList("Pikachu: 'Pi-KA!'", "Pikachu: 'Pika pi!'"))
                .victoryQuotes(Arrays.asList("Pikachu: 'Pika pika! Pikachu!'", "Pikachu: 'Pi pikachu!'"))
                .classifications(Arrays.asList(FighterClassification.ANIMAL, FighterClassification.MONSTER))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new DefensiveStrategy()).build()
                .addAction(new Thunderbolt()).addAction(new IronTail()).addAction(new QuickAttack())
                .addAction(new Protect())
                .addAction(new Catastropika())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
    }
}
