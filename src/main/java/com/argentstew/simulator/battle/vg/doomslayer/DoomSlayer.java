package com.argentstew.simulator.battle.vg.doomslayer;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.AttackType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.OffensiveStrategy;
import com.argentstew.simulator.battle.trait.impl.Demonslayer;
import com.argentstew.simulator.battle.trait.impl.Trickster;
import com.argentstew.simulator.battle.vg.joker.*;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.doomslayer
 * 4/10/2020
 *
 * @author argen
 */
public class DoomSlayer {

    public static final String NAME = "Doom Slayer";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackType.MAGIC, 1.25);
        defenses.set(AttackSubType.PLASMA, 0.8);
        defenses.set(AttackSubType.HANDGUN, 0.8);

        FighterStats stats = FighterStats.builder().strength(6).toughness(8).dexterity(5).aim(6)
                .agility(5.5).speed(5.5).intellect(2.5).willpower(5).size(5).weight(5).build();
        FighterTraits traits = new FighterTraits(Collections.singletonList(new Demonslayer()));
        return Fighter.builder().name(NAME).hp(160).maxHp(160).xStrikeMeter(0)
                .description("A futuristic gunner with experience fighting demons.")
                .entryQuotes(Arrays.asList("The Doom Slayer looks side to side before setting his eyes on his enemy.",
                        "The Doom Slayer has an enraged expression on his face prior to the fight."))
                .victoryQuotes(Arrays.asList("The Doom Slayer readies his shotgun, looking for someone else to fight.",
                        "The Doom Slayer runs off to continue his rampage."))
                .classifications(Collections.singletonList(FighterClassification.HUMANOID))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new OffensiveStrategy()).build()
                .addAction(new Chainsaw()).addAction(new Shotgun()).addAction(new PlasmaGun())
                .addAction(new RocketLauncher())
                .addAction(new BFG9000())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
    }
}
