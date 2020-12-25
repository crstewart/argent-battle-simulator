package com.argentstew.simulator.battle.vg.dracula;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.AttackType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.RangedStrategy;
import com.argentstew.simulator.battle.trait.impl.NaturalAgility;
import com.argentstew.simulator.battle.trait.impl.Teleportation;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.dracula
 * 4/5/2020
 *
 * @author argen
 */
public class Dracula {

    public static final String NAME = "Dracula";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackType.MAGIC, 0.6);
        defenses.set(AttackSubType.FIRE, 1.2);
        defenses.set(AttackSubType.DARK, 0.5);
        defenses.set(AttackSubType.LIGHT, 1.5);

        FighterStats stats = FighterStats.builder().strength(6).toughness(7.5).dexterity(6).aim(6.5)
                .agility(6).speed(6).intellect(7.5).willpower(8.5).size(5).weight(5).build();
        FighterTraits traits = new FighterTraits(Arrays.asList(new NaturalAgility(), new Teleportation()));
        return Fighter.builder().name(NAME).hp(155).maxHp(155).mp(0).maxMp(0).xStrikeMeter(0)
                .description("An undead mage with a variety of powerful but inaccurate spells.")
                .entryQuotes(Arrays.asList("Dracula: 'Have at you!'", "Dracula: 'What are you afraid of?'"))
                .victoryQuotes(Arrays.asList("Dracula: 'What is a man? A miserable little pile of secrets!'",
                        "Dracula: 'It is your faith which has ruled you. Considering that, can you really call me evil?'"))
                .classifications(Collections.singletonList(FighterClassification.UNDEAD))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new RangedStrategy()).build()
                .addAction(new Hellfire()).addAction(new DarkInferno()).addAction(new ElectricWave())
                .addAction(new BatMoon())
                .addAction(new DemonicMegiddo())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
    }
}
