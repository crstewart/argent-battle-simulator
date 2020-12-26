package com.argentstew.simulator.battle.vg.ragna;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.MeleeStrategy;
import com.argentstew.simulator.battle.trait.impl.ComboStrike;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.ragna
 * 3/29/2020
 *
 * @author argen
 */
public class Ragna {

    public static final String NAME = "Ragna the Bloodedge";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackSubType.SLASH, 0.8);
        defenses.set(AttackSubType.HACK, 0.9);
        defenses.set(AttackSubType.PUNCH, 0.8);
        defenses.set(AttackSubType.KICK, 0.8);
        defenses.set(AttackSubType.DARK, 1.3);
        defenses.set(AttackSubType.MYSTIC, 1.2);

        FighterStats stats = FighterStats.builder().strength(7).toughness(7.5).dexterity(4.5).aim(4)
                .agility(5.5).speed(5.5).intellect(5).willpower(2.5).size(5).weight(5).build();
        FighterTraits traits = new FighterTraits(Collections.singletonList(new ComboStrike()));
        return Fighter.builder().name(NAME).hp(160).maxHp(160).mp(0).maxMp(0).xStrikeMeter(0)
                .description("A strong, tough brawler who heals himself with most of his attacks.")
                .entryQuotes(Arrays.asList("Ragna: 'Move it!'", "Ragna: 'Ready?'"))
                .victoryQuotes(Arrays.asList("Ragna: 'There is no hell, only darkness. This is the power of darkness.'",
                        "Ragna: 'Nice try! Get outta here!'"))
                .classifications(Collections.singletonList(FighterClassification.HUMANOID))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new MeleeStrategy()).build()
                .addAction(new BloodScythe()).addAction(new HellsFang()).addAction(new AxKick())
                .addAction(new InfernoDivider()).addAction(new DeadSpike())
                .addAction(new BlackOnslaught())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
    }
}
