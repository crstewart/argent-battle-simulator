package com.argentstew.simulator.battle.vg.charizard;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.OffensiveStrategy;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.charizard
 * 9/8/2019
 *
 * @author Craig
 */
public class Charizard {

    public static final String NAME = "Charizard";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackSubType.PUNCH, 0.75);
        defenses.set(AttackSubType.KICK, 0.75);
        defenses.set(AttackSubType.FIRE, 0.5);
        defenses.set(AttackSubType.WATER, 2);
        defenses.set(AttackSubType.THUNDER, 2);
        defenses.set(AttackSubType.NATURE, 0.25);
        defenses.set(AttackSubType.METAL, 0.5);
        defenses.set(AttackSubType.LIGHT, 0.75);
        defenses.set(AttackSubType.CHI, 0.5);
        defenses.set(AttackSubType.HANDGUN, 0.875);
        defenses.set(AttackSubType.SHOTGUN, 0.875);
        defenses.set(AttackSubType.RIFLE, 0.875);

        FighterStats stats = FighterStats.builder().strength(6.5).toughness(6).dexterity(3).aim(3.5)
                .agility(4).speed(5).intellect(3).willpower(4.5).size(4.5).weight(5).build();
        FighterTraits traits = new FighterTraits();
        return Fighter.builder().name(NAME).hp(160).maxHp(160).xStrikeMeter(0)
                .description("A brawler with a variety of attacks, strengths, and weaknesses.")
                .entryQuotes(Arrays.asList("Charizard breathes fire and stares down its opponent menacingly.",
                        "Charizard swoops down from the sky and lands with a mighty roar!"))
                .victoryQuotes(Arrays.asList("Charizard stomps the ground and roars triumphantly.",
                        "Charizard crosses its arms and lets out a Flamethrower attack into the air."))
                .classifications(Arrays.asList(FighterClassification.DRAGON, FighterClassification.MONSTER))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new OffensiveStrategy()).build()
                .addAction(new Flamethrower()).addAction(new DragonClaw()).addAction(new WingAttack())
                .addAction(new Smokescreen())
                .addAction(new MegaFireBlast())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
    }
}
