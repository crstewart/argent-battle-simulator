package com.argentstew.simulator.battle.vg.steve;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.AttackType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.BalancedStrategy;
import com.argentstew.simulator.battle.vg.marcusfenix.*;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.steve
 * 4/4/2020
 *
 * @author argen
 */
public class Steve {

    public static final String NAME = "Steve";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackSubType.EXPLOSIVE, 1.4);
        defenses.set(AttackSubType.SLASH, 0.8);
        defenses.set(AttackSubType.PIERCE, 0.8);
        defenses.set(AttackSubType.HACK, 0.8);
        defenses.set(AttackSubType.SMASH, 0.8);
        defenses.set(AttackSubType.BITE, 0.8);
        defenses.set(AttackSubType.TAIL, 0.8);
        defenses.set(AttackSubType.HEADBUTT, 0.8);
        defenses.set(AttackSubType.PUNCH, 0.8);
        defenses.set(AttackSubType.KICK, 0.8);

        FighterStats stats = FighterStats.builder().strength(5.5).toughness(5).dexterity(6).aim(6)
                .agility(5.5).speed(5).intellect(5).willpower(5).size(5).weight(5).build();
        FighterTraits traits = new FighterTraits();
        return Fighter.builder().name(NAME).hp(150).maxHp(150).xStrikeMeter(0)
                .description("An all-around fighter who can build blockades to prevent attacks.")
                .entryQuotes(Arrays.asList("Steve turns from his construction to face his opponent.",
                        "Steve dons his armor and prepares for the battle ahead."))
                .victoryQuotes(Arrays.asList("Steve returns to his construction project, having secured victory.",
                        "Steve hears a creeper approaching and runs off to further adventure."))
                .classifications(Collections.singletonList(FighterClassification.HUMANOID))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new BalancedStrategy()).build()
                .addAction(new Pickaxe()).addAction(new TNT()).addAction(new Bow())
                .addAction(new BowCritical()).addAction(new Sword()).addAction(new BuildTerrain())
                .addAction(new DiamondSword())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
    }
}
