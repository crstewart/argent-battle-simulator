package com.argentstew.simulator.battle.vg.heavy;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.AttackType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.BalancedStrategy;
import com.argentstew.simulator.battle.vg.gordonfreeman.*;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.heavy
 * 4/4/2020
 *
 * @author argen
 */
public class Heavy {

    public static final String NAME = "Heavy";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackSubType.SLASH, 1.2);
        defenses.set(AttackSubType.PIERCE, 1.2);
        defenses.set(AttackSubType.FIRE, 1.2);

        FighterStats stats = FighterStats.builder().strength(6.5).toughness(6.5).dexterity(5).aim(6)
                .agility(4).speed(4).intellect(4).willpower(5).size(5.5).weight(5.5).build();
        FighterTraits traits = new FighterTraits();
        return Fighter.builder().name(NAME).hp(200).maxHp(200).xStrikeMeter(0)
                .description("A tank who packs various guns and a healing item.")
                .entryQuotes(Arrays.asList("Heavy: 'Sandvich and I are coming for you!'", "Heavy: 'Run, cowards!'"))
                .victoryQuotes(Arrays.asList("Heavy: 'Some people think they can outsmart me. Maybe. I've yet to meet one that can outsmart bullet.'",
                        "Heavy: 'What sick man sends babies to fight me?'"))
                .classifications(Collections.singletonList(FighterClassification.HUMANOID))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new BalancedStrategy()).build()
                .addAction(new Minigun()).addAction(new Shotgun()).addAction(new Fists())
                .addAction(new Sandvich())
                .addAction(new Natascha())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
    }
}
