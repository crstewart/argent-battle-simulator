package com.argentstew.simulator.battle.vg.rosalina;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.AttackType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.action.move.Sleep;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.BalancedStrategy;
import com.argentstew.simulator.battle.trait.impl.StarGuidance;
import com.argentstew.simulator.battle.trait.impl.Teleportation;

import java.util.Arrays;

/**
 * com.argentstew.simulator.battle.vg.rosalina
 * 8/27/2019
 *
 * @author Craig
 */
public class Rosalina {

    public static final String NAME = "Rosalina";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackType.MAGIC, 0.75);
        defenses.set(AttackSubType.GRAVITY, 0.5);

        FighterStats stats = FighterStats.builder().strength(6).toughness(7).dexterity(5).aim(5)
                .agility(5).speed(4).intellect(9).willpower(8).size(5).weight(5).build();
        FighterTraits traits = new FighterTraits(Arrays.asList(new StarGuidance(), new Teleportation()));
        return Fighter.builder().name(NAME).hp(180).maxHp(180).xStrikeMeter(0)
                .description("A bulky mage who utilizes her Lumas to protect her in battle.")
                .entryQuotes(Arrays.asList("Rosalina: 'My name is Rosalina. I watch over and protect the cosmos.'",
                        "Rosalina: 'This is sure to make for a good match.'"))
                .victoryQuotes(Arrays.asList("Rosalina: 'May the stars shine down on you...'",
                        "Rosalina: 'I may have won, but the distance between us was not so far.'"))
                .classifications(Arrays.asList(FighterClassification.HUMANOID, FighterClassification.DIVINE))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new BalancedStrategy()).build()
                .addAction(new GalaxyBlast()).addAction(new PlanetaryRing()).addAction(new Meteor())
                .addAction(new LumaShot()).addAction(new StarBits()).addAction(new LumaGuard())
                .addAction(new GrandStar())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat()).addAction(new Sleep());
    }
}
