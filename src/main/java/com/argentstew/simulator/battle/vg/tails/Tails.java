package com.argentstew.simulator.battle.vg.tails;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.AttackType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.BalancedStrategy;
import com.argentstew.simulator.battle.strategy.DefensiveStrategy;
import com.argentstew.simulator.battle.trait.impl.Hazardous;
import com.argentstew.simulator.battle.trait.impl.NaturalAgility;
import com.argentstew.simulator.battle.trait.impl.Rival;
import com.argentstew.simulator.battle.vg.sonic.*;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.tails
 * 3/28/2020
 *
 * @author argen
 */
public class Tails {

    public static final String NAME = "Tails";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackType.MAGIC, 1.1);
        defenses.set(AttackSubType.AIR, 1.1);
        defenses.set(AttackSubType.PIERCE, 1.1);

        FighterStats stats = FighterStats.builder().strength(1.5).toughness(2.5).dexterity(8).aim(8)
                .agility(6).speed(8).intellect(8).willpower(4.5).size(4).weight(4).build();
        FighterTraits traits = new FighterTraits(Collections.singletonList(new NaturalAgility()));
        return Fighter.builder().name(NAME).hp(135).maxHp(135).xStrikeMeter(0)
                .description("A speedy fighter who relies on his intellect and technical defenses.")
                .entryQuotes(Arrays.asList("Tails: 'I'll give it my best shot.'",
                        "Tails: 'I know I can do this by myself!'"))
                .victoryQuotes(Arrays.asList("Tails: 'I must be getting stronger!'",
                        "Tails: 'Alls well that ends well, right?'"))
                .classifications(Collections.singletonList(FighterClassification.ANIMAL))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new DefensiveStrategy()).build()
                .addAction(new PropellerDash()).addAction(new TailSwipe()).addAction(new BombDrop())
                .addAction(new EnergyCannon()).addAction(new ShieldBot()).addAction(new MediBot())
                .addAction(new TornadoMechRaid())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
    }
}
