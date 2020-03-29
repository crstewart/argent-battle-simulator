package com.argentstew.simulator.battle.vg.squall;

import com.argentstew.simulator.battle.action.attack.AttackType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.BalancedStrategy;
import com.argentstew.simulator.battle.vg.cloud.*;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.squall
 * 3/29/2020
 *
 * @author argen
 */
public class Squall {

    public static final String NAME = "Squall Leonhart";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackType.MAGIC, 0.9);

        FighterStats stats = FighterStats.builder().strength(4.5).toughness(4.5).dexterity(6).aim(8)
                .agility(6).speed(6.5).intellect(5).willpower(5).size(5).weight(5).build();
        FighterTraits traits = new FighterTraits();
        return Fighter.builder().name(NAME).hp(140).maxHp(140).mp(0).maxMp(10).xStrikeMeter(0)
                .description("A speedy fighter who utilizes magic along with his unique sword.")
                .entryQuotes(Arrays.asList("Squall: 'I'm more complex than you think.'",
                        "Squall: 'I won't hold back.'"))
                .victoryQuotes(Arrays.asList("Squall: 'Everyone has to take care of themselves. I don't want to carry anyone's burden.'",
                        "Squall: 'I refuse to become the past.'"))
                .classifications(Collections.singletonList(FighterClassification.HUMANOID))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new BalancedStrategy()).build()
                .addAction(new Revolver()).addAction(new RoughDivide()).addAction(new FatedCircle())
                .addAction(new FireBarret()).addAction(new BlizzardBarret())
                .addAction(new Renzokuken())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
    }
}
