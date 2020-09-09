package com.argentstew.simulator.battle.vg.agent47;

import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.BalancedStrategy;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.agent47
 * 4/5/2020
 *
 * @author argen
 */
public class Agent47 {

    public static final String NAME = "Agent 47";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();

        FighterStats stats = FighterStats.builder().strength(6.5).toughness(6.5).dexterity(5).aim(7)
                .agility(5).speed(5).intellect(7).willpower(6).size(5).weight(5).build();
        FighterTraits traits = new FighterTraits();
        return Fighter.builder().name(NAME).hp(155).maxHp(155).xStrikeMeter(0)
                .description("A weaponmaster with an arsenal of firearms and stealth tactics at his disposal.")
                .entryQuotes(Arrays.asList("Agent 47: 'Even the strongest chain has a weak point, and I'll find this one.'",
                        "Agent 47: 'Names are for friends, so I don't need one.'"))
                .victoryQuotes(Arrays.asList("Agent 47: 'This bullet. There's a bullet for everyone. And a time, and a place. An end.'",
                        "Agent 47: 'You've obviously learned too much about me. I can't have that.'"))
                .classifications(Collections.singletonList(FighterClassification.HUMANOID))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new BalancedStrategy()).build()
                .addAction(new Silverballer()).addAction(new M4()).addAction(new CombatKnife())
                .addAction(new PoisonSyringe()).addAction(new StealthTakedown())
                .addAction(new M195Sniper())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
    }
}
