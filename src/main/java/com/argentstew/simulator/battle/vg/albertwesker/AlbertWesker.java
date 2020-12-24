package com.argentstew.simulator.battle.vg.albertwesker;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.BalancedStrategy;
import com.argentstew.simulator.battle.trait.impl.NaturalAgility;
import com.argentstew.simulator.battle.trait.impl.Teleportation;
import com.argentstew.simulator.battle.vg.leonkennedy.*;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.albertwesker
 * 3/28/2020
 *
 * @author argen
 */
public class AlbertWesker {

    public static final String NAME = "Albert Wesker";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();

        FighterStats stats = FighterStats.builder().strength(5.5).toughness(3).dexterity(6.5).aim(7.5)
                .agility(6.5).speed(6.5).intellect(6).willpower(4).size(5).weight(5).build();
        FighterTraits traits = new FighterTraits(Arrays.asList(new NaturalAgility(), new Teleportation()));
        return Fighter.builder().name(NAME).hp(140).maxHp(140).xStrikeMeter(0)
                .description("A speedy fighter with a handgun and an explosive finishing move.")
                .entryQuotes(Arrays.asList("Wesker: 'You'll make a nice test subject.'",
                        "Wesker: 'You've really become quite an inconvenience for me.'"))
                .victoryQuotes(Arrays.asList("Wesker: 'Everything is going to plan. I will be a god.'",
                        "Wesker: 'Oh my, new test subjects? Thank you for volunteering.'"))
                .classifications(Collections.singletonList(FighterClassification.HUMANOID))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new BalancedStrategy()).build()
                .addAction(new SamuraiEdge()).addAction(new CobraStrike()).addAction(new GhostButterfly())
                .addAction(new JaguarDash())
                .addAction(new LostInNightmares())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
    }
}
