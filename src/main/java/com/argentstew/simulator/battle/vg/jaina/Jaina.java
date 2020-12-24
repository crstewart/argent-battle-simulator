package com.argentstew.simulator.battle.vg.jaina;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.AttackType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.BalancedStrategy;
import com.argentstew.simulator.battle.trait.impl.Teleportation;
import com.argentstew.simulator.battle.vg.thrall.*;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.jaina
 * 4/4/2020
 *
 * @author argen
 */
public class Jaina {

    public static final String NAME = "Jaina Proudmoore";
    public static final String STATUS_FROSTBITTEN = "Frostbitten";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackType.MAGIC, 0.6);
        defenses.set(AttackSubType.ICE, 0.8);

        FighterStats stats = FighterStats.builder().strength(4).toughness(3.5).dexterity(6).aim(8)
                .agility(4.5).speed(5).intellect(8).willpower(8).size(4.5).weight(4.5).build();
        FighterTraits traits = new FighterTraits(Collections.singletonList(new Teleportation()));
        return Fighter.builder().name(NAME).hp(140).maxHp(140).xStrikeMeter(0)
                .description("A frost mage whose attacks critically hit when chained together.")
                .entryQuotes(Arrays.asList("Jaina: 'For the Alliance!'", "Jaina: 'I hate resorting to violence.'"))
                .victoryQuotes(Arrays.asList("Jaina: 'All things change, whether from inside out or the outside in. That is what magic is.'",
                        "Jaina: 'If only we could've resolved our differences.'"))
                .classifications(Collections.singletonList(FighterClassification.HUMANOID))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new BalancedStrategy()).build()
                .addAction(new Frostbolt()).addAction(new ConeOfCold()).addAction(new IceLance())
                .addAction(new Blizzard()).addAction(new IceBlock())
                .addAction(new RingOfFrost())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
    }
}
