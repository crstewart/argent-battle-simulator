package com.argentstew.simulator.battle.vg.vyse;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.AttackType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.BalancedStrategy;
import com.argentstew.simulator.battle.trait.impl.MechRider;
import com.argentstew.simulator.battle.vg.dreggman.*;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.vyse
 * 3/29/2020
 *
 * @author argen
 */
public class Vyse {

    public static final String NAME = "Vyse";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackType.MAGIC, 0.8);

        FighterStats stats = FighterStats.builder().strength(6).toughness(5.5).dexterity(5.5).aim(5.5)
                .agility(4).speed(5.5).intellect(4.5).willpower(5).size(7).weight(8).build();
        FighterTraits traits = new FighterTraits();
        return Fighter.builder().name(NAME).hp(150).maxHp(150).mp(30).maxMp(30).xStrikeMeter(0)
                .description("An all-around fighter with a mix of magic and counterattacks.")
                .entryQuotes(Arrays.asList("Vyse: 'Bring it on!'", "Vyse: 'No matter what, never give up.'"))
                .victoryQuotes(Arrays.asList("Vyse: 'Impossible is just a word to let people feel good about themselves when they quit.'",
                        "Vyse: 'If we challenge ourselves, and never give up, our own horizons will broaden.'"))
                .classifications(Collections.singletonList(FighterClassification.HUMANOID))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new BalancedStrategy()).build()
                .addAction(new PirateCutlass()).addAction(new CutlassFury()).addAction(new RainOfSwords())
                .addAction(new Pyri()).addAction(new Wevles()).addAction(new Counterstrike())
                .addAction(new PiratesWrath())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
    }
}
