package com.argentstew.simulator.battle.vg.niko;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.BalancedStrategy;
import com.argentstew.simulator.battle.strategy.OffensiveStrategy;
import com.argentstew.simulator.battle.vg.steve.*;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.niko
 * 4/4/2020
 *
 * @author argen
 */
public class NikoBellic {

    public static final String NAME = "Niko Bellic";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();

        FighterStats stats = FighterStats.builder().strength(5.5).toughness(6).dexterity(6.5).aim(7)
                .agility(4.5).speed(5).intellect(4.5).willpower(5).size(5).weight(5).build();
        FighterTraits traits = new FighterTraits();
        return Fighter.builder().name(NAME).hp(150).maxHp(150).xStrikeMeter(0)
                .description("A war-hardened weaponmaster who goes on the offensive when pushed into battle.")
                .entryQuotes(Arrays.asList("Niko: 'War is when the young and stupid are tricked by the old and bitter into killing each other.'",
                        "Niko: 'Well, since you put it that way... I'm in.'"))
                .victoryQuotes(Arrays.asList("Niko: 'There is no such thing as a new beginning. With everyday we live, we have to pick up new baggage.'",
                        "Niko: 'So this is what the dream feels like? This is the victory we longed for.'"))
                .classifications(Collections.singletonList(FighterClassification.HUMANOID))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new OffensiveStrategy()).build()
                .addAction(new MolotovCocktail()).addAction(new BaseballBat()).addAction(new Glock22())
                .addAction(new IthacaModel37())
                .addAction(new Remington700())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
    }
}
