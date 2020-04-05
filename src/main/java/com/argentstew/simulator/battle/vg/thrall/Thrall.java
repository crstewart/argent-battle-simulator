package com.argentstew.simulator.battle.vg.thrall;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.AttackType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.BalancedStrategy;
import com.argentstew.simulator.battle.vg.princeofpersia.*;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.thrall
 * 4/4/2020
 *
 * @author argen
 */
public class Thrall {

    public static final String NAME = "Thrall";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackType.MAGIC, 0.8);
        defenses.set(AttackSubType.FIRE, 0.9);
        defenses.set(AttackSubType.ICE, 0.9);
        defenses.set(AttackSubType.THUNDER, 0.9);
        defenses.set(AttackSubType.AIR, 0.9);
        defenses.set(AttackSubType.EARTH, 0.9);
        defenses.set(AttackSubType.NATURE, 0.9);

        FighterStats stats = FighterStats.builder().strength(6.5).toughness(6).dexterity(6.5).aim(7)
                .agility(4.5).speed(6).intellect(5.5).willpower(6.5).size(5).weight(5).build();
        FighterTraits traits = new FighterTraits();
        return Fighter.builder().name(NAME).hp(160).maxHp(160).xStrikeMeter(0)
                .description("An all-around fighter who commands and resists elemental attacks.")
                .entryQuotes(Arrays.asList("Thrall: 'For the Horde!'", "Thrall: 'Blood and thunder!'"))
                .victoryQuotes(Arrays.asList("Thrall: 'The beginning of wisdom is the statement \"I do not know.\"'",
                        "Thrall: 'How easily the mind can be turned to hate from a place of fear.'"))
                .classifications(Collections.singletonList(FighterClassification.HUMANOID))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new BalancedStrategy()).build()
                .addAction(new ChainLightning()).addAction(new Doomhammer()).addAction(new FeralSpirit())
                .addAction(new Sundering())
                .addAction(new Earthquake())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
    }
}
