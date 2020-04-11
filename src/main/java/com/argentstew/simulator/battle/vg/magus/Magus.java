package com.argentstew.simulator.battle.vg.magus;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.AttackType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.BalancedStrategy;
import com.argentstew.simulator.battle.trait.impl.BarrierChange;
import com.argentstew.simulator.battle.vg.crono.*;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.magus
 * 3/30/2020
 *
 * @author argen
 */
public class Magus {

    public static final String NAME = "Magus";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackType.MAGIC, 0.7);
        defenses.set(AttackSubType.SLASH, 1.05);

        FighterStats stats = FighterStats.builder().strength(3).toughness(4).dexterity(4).aim(8)
                .agility(4).speed(3.5).intellect(7.5).willpower(8).size(5).weight(5).build();
        FighterTraits traits = new FighterTraits(Collections.singletonList(new BarrierChange()));
        return Fighter.builder().name(NAME).hp(140).maxHp(140).xStrikeMeter(0)
                .description("A mage with dark magic and a varying elemental barrier.")
                .entryQuotes(Arrays.asList("Magus: 'Give me your best shot... If you're prepared for the void!",
                        "Magus: 'Do you wish to fight me?'"))
                .victoryQuotes(Arrays.asList("Magus: 'The weak always strive to be weaker...'",
                        "Magus: 'The past is dead. It was all just a dream...'"))
                .classifications(Collections.singletonList(FighterClassification.HUMANOID))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new BalancedStrategy()).build()
                .addAction(new DarkBomb()).addAction(new FireII()).addAction(new IceII())
                .addAction(new LightningII()).addAction(new Scythe())
                .addAction(new DarkMatter())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
    }
}
