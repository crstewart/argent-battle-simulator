package com.argentstew.simulator.battle.vg.peach;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.AttackType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.BalancedStrategy;
import com.argentstew.simulator.battle.trait.impl.Rival;
import com.argentstew.simulator.battle.vg.bowser.Bowser;
import com.argentstew.simulator.battle.vg.mario.*;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.peach
 * 8/26/2019
 *
 * @author Craig
 */
public class Peach {

    public static final String NAME = "Peach";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackType.MAGIC, 0.7);
        defenses.set(AttackSubType.PIERCE, 1.2);
        defenses.set(AttackSubType.FIRE, 1.2);

        FighterStats stats = FighterStats.builder().strength(3).toughness(3).dexterity(7).aim(6)
                .agility(7).speed(5).intellect(5).willpower(7).size(4).weight(4).build();
        FighterTraits traits = new FighterTraits();
        return Fighter.builder().name(NAME).hp(140).maxHp(140).mp(25).maxMp(25).xStrikeMeter(0)
                .entryQuotes(Arrays.asList("Peach: 'Yay! Peach! Let's go!'", "Peach: 'Leave it to me!'"))
                .victoryQuotes(Arrays.asList("Peach: 'Ohhh, did I win?'",
                        "Peach: 'I won! Oh, yay for me!'"))
                .classifications(Collections.singletonList(FighterClassification.HUMANOID))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new BalancedStrategy()).build()
                .addAction(new FryingPan()).addAction(new PeachParasol()).addAction(new Vegetable())
                .addAction(new SweetKiss()).addAction(new Therapy())
                .addAction(new PsychBomb())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
    }
}
