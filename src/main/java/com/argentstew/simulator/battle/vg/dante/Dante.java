package com.argentstew.simulator.battle.vg.dante;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.AttackType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.BalancedStrategy;
import com.argentstew.simulator.battle.trait.impl.Demonslayer;
import com.argentstew.simulator.battle.vg.morrigan.*;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.dante
 * 3/28/2020
 *
 * @author argen
 */
public class Dante {

    public static final String NAME = "Dante";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackType.MAGIC, 0.8);
        defenses.set(AttackSubType.LIGHT, 1.25);
        defenses.set(AttackSubType.DARK, 1.25);

        FighterStats stats = FighterStats.builder().strength(8).toughness(4.5).dexterity(5).aim(5)
                .agility(7.5).speed(8).intellect(5).willpower(5.5).size(5).weight(5).build();
        FighterTraits traits = new FighterTraits(Collections.singletonList(new Demonslayer()));
        return Fighter.builder().name(NAME).hp(140).maxHp(140).xStrikeMeter(0)
                .description("A speedy fighter with a wide array of attack options.")
                .entryQuotes(Arrays.asList("Dante: 'Let's rock baby!'",
                        "Dante: 'So, you want a piece of me. Come and get it, if you can!'"))
                .victoryQuotes(Arrays.asList("Dante: 'Demons, superhumans. Meh. Same crap, different day.'",
                        "Dante: 'I hope for your sake you have some other redeeming qualities other than fighting.'"))
                .classifications(Arrays.asList(FighterClassification.HUMANOID, FighterClassification.DEMONIC))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new BalancedStrategy()).build()
                .addAction(new Rebellion()).addAction(new EbonyAndIvory()).addAction(new JamSession())
                .addAction(new Crystal()).addAction(new Twister()).addAction(new Volcano())
                .addAction(new FinaleStinger())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
    }
}
