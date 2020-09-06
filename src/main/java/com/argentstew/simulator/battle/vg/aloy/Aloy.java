package com.argentstew.simulator.battle.vg.aloy;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.BalancedStrategy;
import com.argentstew.simulator.battle.strategy.OffensiveStrategy;
import com.argentstew.simulator.battle.strategy.RangedStrategy;
import com.argentstew.simulator.battle.trait.impl.MechScrapper;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.aloy
 * 3/28/2020
 *
 * @author argen
 */
public class Aloy {

    public static final String NAME = "Aloy";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();

        FighterStats stats = FighterStats.builder().strength(4.5).toughness(6.5).dexterity(6).aim(8)
                .agility(4.5).speed(5).intellect(8).willpower(6).size(4.5).weight(4.5).build();
        FighterTraits traits = new FighterTraits(Collections.singletonList(new MechScrapper()));
        return Fighter.builder().name(NAME).hp(145).maxHp(145).xStrikeMeter(0)
                .description("A stealthy weaponmaster who excels at taking down mechs.")
                .entryQuotes(Arrays.asList("Aloy: 'Stop there if you want me to hear you out.'",
                        "Aloy: 'I think I have a minute for you. Maybe even two.'"))
                .victoryQuotes(Arrays.asList("Aloy: 'You make it so hard to like you.'",
                        "Aloy: 'You're an idiot. A dangerous idiot - but an idiot.'"))
                .classifications(Collections.singletonList(FighterClassification.HUMANOID))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new RangedStrategy()).build()
                .addAction(new SharpshotBow()).addAction(new BlastSling()).addAction(new Spear())
                .addAction(new Tearblaster()).addAction(new Stormslinger())
                .addAction(new DeathbringerGun())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
    }
}
