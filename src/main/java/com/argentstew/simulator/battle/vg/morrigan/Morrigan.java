package com.argentstew.simulator.battle.vg.morrigan;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.AttackType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.BalancedStrategy;
import com.argentstew.simulator.battle.trait.impl.NaturalAgility;
import com.argentstew.simulator.battle.vg.viewtifuljoe.*;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.morrigan
 * 3/28/2020
 *
 * @author argen
 */
public class Morrigan {

    public static final String NAME = "Morrigan Aensland";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackType.MAGIC, 0.7);
        defenses.set(AttackSubType.LIGHT, 1.25);
        defenses.set(AttackSubType.DARK, 0.75);

        FighterStats stats = FighterStats.builder().strength(6).toughness(2).dexterity(6).aim(6.5)
                .agility(5).speed(4.5).intellect(4.5).willpower(6).size(4.5).weight(4.5).build();
        FighterTraits traits = new FighterTraits(Collections.emptyList());
        return Fighter.builder().name(NAME).hp(145).maxHp(145).xStrikeMeter(0)
                .description("An anti-mage who has the ability to sap her opponent's X-Strike power.")
                .entryQuotes(Arrays.asList("Morrigan: 'Eternity can be lonely. Please keep me company...'",
                        "Morrigan: 'Don't let me scare you...'"))
                .victoryQuotes(Arrays.asList("Morrigan: 'Your soul is strong. May I borrow it... forever?'",
                        "Morrigan: 'Mmm, that really did not satisfy my urge. I'm going to have to look for someone else to take care of me.'"))
                .classifications(Collections.singletonList(FighterClassification.DEMONIC))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new BalancedStrategy()).build()
                .addAction(new SoulFist()).addAction(new SoulDrain()).addAction(new ShadowBlade())
                .addAction(new VectorDrain())
                .addAction(new DarknessIllusion())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
    }
}
