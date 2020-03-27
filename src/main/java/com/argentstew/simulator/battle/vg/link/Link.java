package com.argentstew.simulator.battle.vg.link;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.AttackType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.BalancedStrategy;
import com.argentstew.simulator.battle.strategy.OffensiveStrategy;
import com.argentstew.simulator.battle.trait.impl.Rival;
import com.argentstew.simulator.battle.vg.ganondorf.Ganondorf;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.link
 * 8/27/2019
 *
 * @author Craig
 */
public class Link {

    public static final String NAME = "Link";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackType.MELEE, 0.9);
        defenses.set(AttackType.RANGED, 0.9);
        defenses.set(AttackType.MAGIC, 0.8);
        defenses.set(AttackSubType.PIERCE, 1.12);
        defenses.set(AttackSubType.ARMOR_PIERCING, 1.12);
        defenses.set(AttackSubType.FIRE, 1.2);

        FighterStats stats = FighterStats.builder().strength(6).toughness(6).dexterity(9).aim(7)
                .agility(5).speed(4).intellect(5).willpower(8).size(5).weight(5).build();
        FighterTraits traits = new FighterTraits(Collections.singletonList(new Rival(Ganondorf.NAME, 1.1)));
        return Fighter.builder().name(NAME).hp(150).maxHp(150).xStrikeMeter(0)
                .description("A weaponmaster with a variety of accurate attacks who deals extra damage against Ganondorf.")
                .entryQuotes(Arrays.asList("Navi: 'Hey! Listen! Watch out!'",
                        "Fi: 'Master, I predict an 85% chance of victory against this foe.'"))
                .victoryQuotes(Arrays.asList("Link swings and spins his sword before sheathing it triumphantly.",
                        "Midna: 'So, you're not absolutely stupid after all!'"))
                .classifications(Collections.singletonList(FighterClassification.HUMANOID))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new BalancedStrategy()).build()
                .addAction(new MasterSword()).addAction(new HerosBow()).addAction(new Bomb())
                .addAction(new Hookshot()).addAction(new HylianShield())
                .addAction(new TriforceSlash())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
    }
}
